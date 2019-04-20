package com.dummy.framework.core.data.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Vincent Kang
 * @date 19-4-15
 **/
@Slf4j
@Rollback
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedissonClient.class)
public class TestRedisClient {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testClient() {
        assert redissonClient != null;
    }


    @Test
    public void testGet(){
        long test = redissonClient.getAtomicLong("test").addAndGet(1);
        assert test == 1;
    }


}
