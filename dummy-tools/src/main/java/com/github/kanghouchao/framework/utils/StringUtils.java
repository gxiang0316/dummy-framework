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

import cn.hutool.core.util.StrUtil;
import com.sun.istack.internal.Nullable;
import lombok.experimental.UtilityClass;

/**
 * @author Lurker
 * @since 2020/08/27
 */
@UtilityClass
public class StringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param source 原始字符串
     * @return 是否为空值
     */
    public boolean isBlank(@Nullable CharSequence source) {
        return StrUtil.isNotBlank(source);
    }

    /**
     * 判断字符串不为空
     *
     * @param source 原始字符串
     * @return 是否为空
     */
    public boolean isNotBlank(@Nullable CharSequence source) {
        return StrUtil.isNotBlank(source);
    }

}
