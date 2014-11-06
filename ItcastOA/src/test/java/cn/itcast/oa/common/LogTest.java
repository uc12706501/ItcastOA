package cn.itcast.oa.common;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 * 测试日志级别
 */
public class LogTest extends TestCase {
    public void testLog(){
        Logger log=Logger.getLogger(this.getClass());
        log.debug("log debug");
        log.info("log info");
        log.warn("log warning");
        log.error("log error");
        log.fatal("log fatal");
    }
}
