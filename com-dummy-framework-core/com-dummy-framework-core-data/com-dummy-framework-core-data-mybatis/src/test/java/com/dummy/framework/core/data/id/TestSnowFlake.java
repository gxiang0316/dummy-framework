package com.dummy.framework.core.data.id;

import org.junit.Test;
import xyz.downgoon.snowflake.Snowflake;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 雪花算法包junit测试
 *
 * @author Vincent Kang
 * @date 19-4-21
 **/
public class TestSnowFlake {

    @Test
    public void testGetId() {
        Snowflake snowflake = new Snowflake(2, 5);
        Long id = snowflake.nextId();
        System.out.println(String.format("TestSnowFlake.testGetId,id is %d", id));
    }

    @Test
    public void testGetIdA() throws InterruptedException {
        final Snowflake snowflake = new Snowflake(2, 5);
        ExecutorService service = Executors.newSingleThreadExecutor();
        final CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                        System.out.println(String.format("TestSnowFlake.testGetId,time is %d, count is %d, id is %d", System.currentTimeMillis(), countDownLatch.getCount(), snowflake.nextId()));
                        countDownLatch.countDown();
                    }
            );
        }
        countDownLatch.await();
        service.shutdown();
    }

}
