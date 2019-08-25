package com.dummy.framework.core.data.mybatis.id;

import com.dummy.framework.common.SystemParameter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(SystemParameter.SYSTEM_NAME)
public class IDGeneratorSwitch {

    private IDGeneratorType generatorType;

}
