package com.dummy.framework.core.data.mybatis.id.snowflake;

import com.dummy.framework.common.SystemParameter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(SystemParameter.SYSTEM_NAME + ".snowflake-strategy")
public class SnowflakeIDGeneratorProperties {

    private Long workerId;

    private Long dataCenterId;

}
