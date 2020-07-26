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

package com.dummy.framework.mybatisplus.core.hanndlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author Lurker
 * @since 2020/07/26
 */
@Slf4j
public class BaseEntityHandler implements MetaObjectHandler {

    /**
     * id类型判断符
     */
    private final static String ID_TYPE = "java.lang.String";

    private long workerId;
    private long dataCenterId;

    /**
     * @param workerId     终端ID
     * @param dataCenterId 数据中心ID
     */
    public BaseEntityHandler(long workerId, long dataCenterId) {
        super();
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
