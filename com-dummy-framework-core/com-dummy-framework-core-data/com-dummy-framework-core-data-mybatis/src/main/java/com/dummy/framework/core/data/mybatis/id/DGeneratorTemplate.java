package com.dummy.framework.core.data.mybatis.id;

import com.dummy.framework.utils.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;

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
