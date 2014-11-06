package cn.itcast.oa.common;

import cn.itcast.oa.service.TestService;
import cn.itcast.oa.view.action.TestAction;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lkk on 2014/11/4.
 */
public class SpringTest extends TestCase {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

    public void testBean(){
        TestAction ta= (TestAction) applicationContext.getBean("testAction");
        assertNotNull(ta);
    }

    public void testSessionFactory(){
        SessionFactory sessionFactory= (SessionFactory) applicationContext.getBean("sessionFactory");
        assertNotNull(sessionFactory);
    }

    @Transactional
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
