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
package com.dummy.framework.core.data.mybatis.id;

import com.dummy.framework.utils.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/31
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Slf4j
public class DGeneratorTemplate implements IDGenerator {

    private final IDGenerator idGenerator;

    public DGeneratorTemplate() {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>DGeneratorTemplate.....初始化!");
        idGenerator = ApplicationContextProvider.getBean(IDGenerator.class);
    }

    @Override
    public Object genId(String table, String column) {
        log.debug("{}通过{}获取主键,{}", table, idGenerator.getClass(), column);
        return idGenerator.genId(table, column);
    }
}
