package com.dummy.framework.core.data.db;

import com.dummy.framework.core.data.db.entity.TestEntity;
import com.dummy.framework.core.data.db.testmapper.TestMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Vincent Kang
 * @date 19-3-31
 **/
@Slf4j
@Rollback
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestMapper.class)
@MapperScan(basePackages = "com.dummy.framework.core.data.db.testmapper")
public class Tests {

    @Autowired
    private TestMapper testMapper;


    @Test
    public void testConfiguration() {
        assert testMapper != null;
    }

    @Test
    public void testInsert() {
        TestEntity entity = new TestEntity();
        entity.setPassword("wf6032483@");
        entity.setUsername("vincent kang");
        int count = testMapper.insert(entity);
        log.debug("count is {}.", count);
        assert count > 0;
    }

    @Test
    public void testSelectById() {
        final TestEntity entity = testMapper.selectById(1L);
        log.debug("entity is {}.", entity);
        assert entity.getPassword().equals("wf6032483@");
    }

    @Test
    public void testSelectAll() {
        PageHelper.startPage(1, 2);
        PageInfo<TestEntity> entityPageInfo = PageInfo.of(this.testMapper.selectAll());
        log.debug("entityPageInfo is {}", entityPageInfo);
        assert entityPageInfo.getSize() > 0;
    }

}
