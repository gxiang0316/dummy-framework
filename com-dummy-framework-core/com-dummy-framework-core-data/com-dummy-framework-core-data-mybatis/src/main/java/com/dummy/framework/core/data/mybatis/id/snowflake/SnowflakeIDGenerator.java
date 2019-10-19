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
package com.dummy.framework.core.data.mybatis.id.snowflake;

import com.dummy.framework.common.SystemParameter;
import com.dummy.framework.core.data.mybatis.id.IDGenerator;
import com.dummy.framework.core.data.mybatis.id.IDGeneratorSwitch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import xyz.downgoon.snowflake.Snowflake;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/31
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({IDGeneratorSwitch.class, SnowflakeIDGeneratorProperties.class})
@ConditionalOnProperty(prefix = SystemParameter.SYSTEM_NAME, name = "generator-type", havingValue = "SNOW_FLAKE")
public class SnowflakeIDGenerator implements IDGenerator<Long> {

    private Snowflake snowflake;

    public SnowflakeIDGenerator(SnowflakeIDGeneratorProperties properties) {
        snowflake = new Snowflake(properties.getDataCenterId(), properties.getWorkerId());
    }

    @Override
    public Long genId(String table, String column) {
        return this.snowflake.nextId();
    }
}
