/*
 * Copyright 2019 kanghouchao
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kanghouchao.framework.web.servlet.mvc.method.annotation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Lurker
 * @since 05 8月 2020
 */
public class EmojiHandleRequestBodyAdviceTest {

    private final static String content = "{\n" +
            "    \"id\": 17293726,\n" +
            "    \"name\": \"康厚超\uD83D\uDE01\",\n" +
            "    \"age\": 32,\n" +
            "    \"remark\": \"这个人只字未写\uD83E\uDD7A\"\n" +
            "}";
    private MethodParameter paramType;
    private Class<? extends HttpMessageConverter<?>> converterType;
    private ServerHttpRequest request;

    @Before
    public void setup() {
        this.converterType = StringHttpMessageConverter.class;
        this.paramType = new MethodParameter(ClassUtils.getMethod(this.getClass(), "handle", TestObject.class), 0);
    }

    @Test
    public void supports() {
        RequestBodyAdvice requestAdvice = new EmojiHandleRequestBodyAdvice();
        Assert.assertFalse(requestAdvice.supports(this.paramType, TestObject.class, this.converterType));
    }

    @Test
    public void requestBodyAdvice() throws IOException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setContent(content.getBytes(StandardCharsets.UTF_8));
        this.request = new ServletServerHttpRequest(mockHttpServletRequest);
        RequestBodyAdvice requestAdvice = new EmojiHandleRequestBodyAdvice();
        HttpInputMessage httpInputMessage = requestAdvice.beforeBodyRead(this.request, this.paramType, TestObject.class, this.converterType);
        Assert.assertNotNull(httpInputMessage);
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (httpInputMessage.getBody(), Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }
        Assert.assertNotNull(textBuilder.toString());
    }

    @SuppressWarnings("unused")
    @ResponseBody
    public String handle(@EnableEmoji TestObject body) {
        return "";
    }
}
