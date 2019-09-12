package com.dummy.framework.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestApplicationContextProvider {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @Test
    public void testGetApplication() {
        assert applicationContextProvider != null;
    }

}
