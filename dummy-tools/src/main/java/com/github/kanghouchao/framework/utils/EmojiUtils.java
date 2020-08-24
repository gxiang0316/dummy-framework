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

import com.vdurmont.emoji.EmojiParser;
import lombok.experimental.UtilityClass;

/**
 * 字符串操作工作类，主要用于处理字符串中的表情字符
 *
 * @author Lurker
 * @since 2020/08/24
 */
@UtilityClass
public class EmojiUtils {


    /**
     * 去除字符串中的表情元素
     *
     * @param source 原始字符串
     * @return 没有表情元素的字符串
     */
    public String removeAllEmojis(String source) {
        return EmojiParser.removeAllEmojis(source);
    }
}
