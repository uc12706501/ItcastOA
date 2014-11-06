package cn.itcast.oa.dao.impl;

import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserDao userDao;

    @Test
    public void testCUDR() throws Exception {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setName("Bob");
        user2.setName("Jone");
        user3.setName("Lv");

        //测试保存
        Long id1= (Long) userDao.save(user1);
        assertNotNull(id1);
        User fetchedUser1=userDao.getById(id1);
        assertEquals(user1,fetchedUser1);

        Long id2= (Long) userDao.save(user1);
        assertNotNull(id2);
        User fetchedUser2=userDao.getById(id2);
        assertEquals(user1,fetchedUser2);

        Long id3= (Long) userDao.save(user1);
        assertNotNull(id3);
        User fetchedUser3=userDao.getById(id3);
        assertEquals(user1,fetchedUser3);

        //测试删除
//        userDao.delete(id);
//        User deletedUser=userDao.getById(id);
//        assertNull(deletedUser);
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