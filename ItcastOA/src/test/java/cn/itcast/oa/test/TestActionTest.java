package cn.itcast.oa.test;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lkk on 2014/11/4.
 */
public class TestActionTest extends TestCase {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    public void testCreate(){
        TestAction ta= (TestAction) applicationContext.getBean("testAction");
        assertNotNull(ta);
    }
}
