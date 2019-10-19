/*
  Copyright 2019 kanghouchao
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.dummy.framework.utils;

import lombok.experimental.UtilityClass;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@UtilityClass
public class Base64Util extends org.springframework.util.Base64Utils {

    /**
     * 编码
     *
     * @param value 字符串
     * @return {String}
     */
    public static String encode(String value) {
        return encode(value, StandardCharsets.UTF_8);
    }

    /**
     * 编码
     *
     * @param value   字符串
     * @param charset 字符集
     * @return {String}
     */
    public static String encode(String value, Charset charset) {
        byte[] val = value.getBytes(charset);
        return new String(Base64Util.encode(val), charset);
    }

    /**
     * 编码URL安全
     *
     * @param value 字符串
     * @return {String}
     */
    public static String encodeUrlSafe(String value) {
        return encodeUrlSafe(value, StandardCharsets.UTF_8);
    }

    /**
     * 编码URL安全
     *
     * @param value   字符串
     * @param charset 字符集
     * @return {String}
     */
    public static String encodeUrlSafe(String value, Charset charset) {
        byte[] val = value.getBytes(charset);
        return new String(encodeUrlSafe(val), charset);
    }

    /**
     * 解码
     *
     * @param value 字符串
     * @return {String}
     */
    public static String decode(String value) {
        return decode(value, StandardCharsets.UTF_8);
    }

    /**
     * 解码
     *
     * @param value   字符串
     * @param charset 字符集
     * @return {String}
     */
    public static String decode(String value, Charset charset) {
        byte[] val = value.getBytes(charset);
        byte[] decodedValue = Base64Util.decode(val);
        return new String(decodedValue, charset);
    }

    /**
     * 解码URL安全
     *
     * @param value 字符串
     * @return {String}
     */
    public static String decodeUrlSafe(String value) {
        return Base64Util.decodeUrlSafe(value, StandardCharsets.UTF_8);
    }

    /**
     * 解码URL安全
     *
     * @param value   字符串
     * @param charset 字符集
     * @return {String}
     */
    public static String decodeUrlSafe(String value, java.nio.charset.Charset charset) {
        byte[] val = value.getBytes(charset);
        byte[] decodedValue = Base64Util.decodeUrlSafe(val);
        return new String(decodedValue, charset);
    }
}
