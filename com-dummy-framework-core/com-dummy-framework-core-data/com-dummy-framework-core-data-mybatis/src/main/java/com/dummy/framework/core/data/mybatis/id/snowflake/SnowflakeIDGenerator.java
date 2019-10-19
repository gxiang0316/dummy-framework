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
