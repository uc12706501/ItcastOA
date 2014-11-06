package cn.itcast.oa.dao.impl;

import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.domain.User;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest extends TestCase {

    ApplicationContext applicationContext;
    UserDao userDao;
    public UserDaoImplTest(){
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao= (UserDao) applicationContext.getBean("userDao");
    }

    public void testSaveAndDelete() throws Exception {
        User user=new User();
        user.setName("Bob");

        //测试保存
        Long id= (Long) userDao.save(user);
        assertNotNull(id);
        User fetchedUser=userDao.getById(id);
        assertEquals(user,fetchedUser);

        //测试删除
        userDao.delete(id);
        User deletedUser=userDao.getById(id);
        assertNull(deletedUser);
    }

    public void testUpdate() throws Exception {

    }

    public void testGetById() throws Exception {

    }

    public void testGetAll() throws Exception {

    }

    public void testGetByIds() throws Exception {

    }
}