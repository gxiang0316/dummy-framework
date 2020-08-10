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

package com.dummy.framework.mybatisplus.core.hanndlers;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import lombok.Data;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.reflection.MetaObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Lurker
 * @since {YEAR}/{MONTH}/{DAY}
 */
public class EntityHandlerTests {

    private static final MybatisConfiguration configuration = new MybatisConfiguration();
    private static final MapperBuilderAssistant assistant = new MapperBuilderAssistant(configuration, "");

    @Before
    public void initXt() {
        TableInfoHelper.initTableInfo(assistant, Xt.class);
    }

    @Test
    public void testFillInsert() {
        MetaObjectHandler entityHandler = new EntityHandler();
        Xt xt = new Xt();
        MetaObject metaObject = configuration.newMetaObject(xt);
        entityHandler.insertFill(metaObject);
        Assert.assertNotNull(xt.getCreateTime());
    }

    @Data
    static class Xt {

        @TableId(type = IdType.ASSIGN_ID)
        private String id;

        private String name;

        private Integer age;

        private LocalDate birthday;

        private LocalDateTime dateTime;

        @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createTime;

        private String createUserId;

        @TableField(fill = FieldFill.UPDATE)
        private LocalDateTime modifyTime;

        private String modifyUserId;
    }

}
