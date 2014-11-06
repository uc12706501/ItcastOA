package cn.itcast.oa.common;

import cn.itcast.oa.service.TestService;
import cn.itcast.oa.view.action.TestAction;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by lkk on 2014/11/4.
 */
public class SpringTest {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testBean(){
        TestAction ta= (TestAction) applicationContext.getBean("testAction");
        assertNotNull(ta);
    }

    @Test
    public void testSessionFactory(){
        SessionFactory sessionFactory= (SessionFactory) applicationContext.getBean("sessionFactory");
        assertNotNull(sessionFactory);
    }

    @Test
    public void testTransaction(){
        TestService service= (TestService) applicationContext.getBean("testService");
        assertNotNull(service);

        service.AddTwoUserSuccess();
        assertEquals(new Long(2),service.SumUser());

        try {
            service.AddTwoUserFail();
        }
        catch (ArithmeticException e){
            assertEquals(new Long(2),service.SumUser());
            return;
        }
        fail("fail to catch arithmeticException");
    }
}
