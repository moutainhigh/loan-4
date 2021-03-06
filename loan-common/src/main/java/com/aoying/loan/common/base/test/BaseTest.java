package com.aoying.loan.common.base.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author nick
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
