package com.dummy.framework.core.data.db.testmapper;

import com.dummy.framework.core.data.db.mapper.BaseMapper;
import com.dummy.framework.core.data.db.entity.TestEntity;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
public interface TestMapper extends BaseMapper<TestEntity> {

    /**
     * 根据ID查询实体类
     *
     * @param id id
     * @return 实体
     */
    TestEntity selectById(Long id);

}
