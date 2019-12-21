package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple SpringApp.
 */
public class SpringAppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test1() {
        Logger logger = LoggerFactory.getLogger(SpringAppTest.class);
        logger.debug("test1-debug");
        logger.info("test1-info");
        logger.error("test1-error");
    }
}
