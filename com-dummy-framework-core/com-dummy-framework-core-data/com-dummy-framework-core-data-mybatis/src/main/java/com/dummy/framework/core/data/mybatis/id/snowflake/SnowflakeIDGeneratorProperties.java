package com.dummy.framework.core.data.mybatis.id.snowflake;

import com.dummy.framework.common.SystemParameter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/03/31
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Data
@ConfigurationProperties(SystemParameter.SYSTEM_NAME + ".snowflake-strategy")
public class SnowflakeIDGeneratorProperties {

    private Long workerId;

    private Long dataCenterId;

}
