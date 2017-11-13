package com.example.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hutingcong on 2017/10/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test(){
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}
