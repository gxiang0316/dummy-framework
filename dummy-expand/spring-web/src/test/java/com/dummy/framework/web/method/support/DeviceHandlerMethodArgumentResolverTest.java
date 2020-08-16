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

package com.github.kanghouchao.framework.web.method.support;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;

import java.lang.reflect.Method;

/**
 * @author Lurker
 * @since 04 8月 2020
 */
public class DeviceHandlerMethodArgumentResolverTest {

    private HandlerMethodArgumentResolverComposite resolverComposite;

    private MethodParameter paramDeviceInfo;

    @Before
    public void setup() throws Exception {
        this.resolverComposite = new HandlerMethodArgumentResolverComposite();
        Method method = getClass().getDeclaredMethod("handle", DeviceInfo.class);
        paramDeviceInfo = new MethodParameter(method, 0);
        this.resolverComposite.addResolver(new DeviceHandlerMethodArgumentResolver());
    }

    @Test
    public void supportsParameter() {
        Assert.assertTrue(this.resolverComposite.supportsParameter(paramDeviceInfo));
    }

    @Test
    public void resolveArgument() throws Exception {
        final String id = "test_device_info_id";
        Object resolvedValue = resolverArgument(id);
        Assert.assertNotNull(resolvedValue);
        Assert.assertTrue(resolvedValue.getClass().isAssignableFrom(DeviceInfo.class));
        Assert.assertEquals(id, ((DeviceInfo) resolvedValue).getId());
    }

    @Test
    public void resolveNoArgument() throws Exception {
        Object resolvedValue = resolverArgument(null);
        Assert.assertNull(resolvedValue);
    }

    private Object resolverArgument(String id) throws Exception {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        if (StringUtils.hasText(id)) {
            final String requestHeaderDeviceKey = "x-device-id";
            mockHttpServletRequest.addHeader(requestHeaderDeviceKey, id);
        }
        ServletWebRequest servletRequest = new ServletWebRequest(mockHttpServletRequest);
        return this.resolverComposite.resolveArgument(paramDeviceInfo, null, servletRequest, null);
    }

    @SuppressWarnings("unused")
    private void handle(@RequestHeader DeviceInfo o) {
    }

}
