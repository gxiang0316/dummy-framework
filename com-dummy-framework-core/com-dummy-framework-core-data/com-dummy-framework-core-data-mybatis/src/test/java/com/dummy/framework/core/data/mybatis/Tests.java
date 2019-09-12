package com.dummy.framework.core.data.mybatis;

import com.dummy.framework.core.data.mybatis.entity.TestEntity;
import com.dummy.framework.core.data.mybatis.testmapper.TestMapper;
import com.dummy.framework.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
@Slf4j
@Rollback
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestMapper.class)
@MapperScan(basePackages = "com.dummy.framework.core.data.mybatis.testmapper")
public class Tests {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testConfiguration() {
        assert testMapper != null;
    }

    @Test
    public void testInsert() {
        TestEntity testEntity = new TestEntity();
        testEntity.setUsername("kanghouchao");
        testEntity.setPassword(MD5Utils.encode("wf6032483@"));
        testMapper.insertSelective(testEntity);
    }

    @Test
    public void testSelectById() {
        TestEntity entity = testMapper.selectById(483045227797041152L);
        log.debug("entity is {}", entity);
    }

    @Test
    public void testSelectAll() {
        testMapper.selectAll();
    }

}
