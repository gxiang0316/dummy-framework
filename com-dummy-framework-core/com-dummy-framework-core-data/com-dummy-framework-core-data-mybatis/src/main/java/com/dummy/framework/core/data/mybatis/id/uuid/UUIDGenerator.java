package com.dummy.framework.core.data.mybatis.id.uuid;

import com.dummy.framework.common.SystemParameter;
import com.dummy.framework.core.data.mybatis.id.IDGenerator;
import com.dummy.framework.core.data.mybatis.id.IDGeneratorSwitch;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Configuration
@NoArgsConstructor
@EnableConfigurationProperties(IDGeneratorSwitch.class)
@ConditionalOnProperty(prefix = SystemParameter.SYSTEM_NAME, name = "generator-type", havingValue = "UUID")
public class UUIDGenerator implements IDGenerator<String> {

    @Override
    public String genId(String table, String column) {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString().replace(StringPool.DASH, StringPool.EMPTY);
    }
}
