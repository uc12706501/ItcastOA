package cn.itcast.oa.common;

import cn.itcast.oa.service.TestService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by lkk on 2014/11/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    SessionFactory sessionFactory;
    @Resource
    TestService service;


    @Test
    public void testTransaction(){
        assertNotNull(service);

        service.AddUser(true);
        assertEquals(new Long(1),service.SumUser());

        try {
            service.AddUser(false);
        }
        catch (IllegalArgumentException e){
            assertEquals(new Long(1),service.SumUser());
            return;
        }
        fail("fail to catch Exception");
    }
}
