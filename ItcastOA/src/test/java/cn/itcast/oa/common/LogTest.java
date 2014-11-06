package cn.itcast.oa.common;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 测试日志级别
 */
public class LogTest{
    @Test
    public void testLog(){
        Logger log=Logger.getLogger(this.getClass());
        log.debug("log debug");
        log.info("log info");
        log.warn("log warning");
        log.error("log error");
        log.fatal("log fatal");
    }
}
