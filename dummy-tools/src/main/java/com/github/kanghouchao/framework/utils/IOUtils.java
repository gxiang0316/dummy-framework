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

package com.github.kanghouchao.framework.utils;

import cn.hutool.core.io.IoUtil;
import lombok.experimental.UtilityClass;

import java.io.InputStream;

/**
 * @author Lurker
 * @since 2020/08/24
 */
@UtilityClass
public class IOUtils {

    /**
     * 读取流
     *
     * @param body
     * @return
     */
    public byte[] readBytes(InputStream body) {
        return IoUtil.readBytes(body);
    }
}
