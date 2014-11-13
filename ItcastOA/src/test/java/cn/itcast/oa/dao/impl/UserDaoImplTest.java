package cn.itcast.oa.dao.impl;

import cn.itcast.oa.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserDao userDao;

    //todo 重构，将各个功能的测试分开
    @Test
    public void testCUDR() throws Exception {
//        User user1=new User();
//        User user2=new User();
//        User user3=new User();
//        user1.setName("Bob");
//        user2.setName("Jone");
//        user3.setName("Lv");
//
//        //测试保存
//        Long id1= (Long) userDao.save(user1);
//        assertNotNull(id1);
//        assertEquals(user1,userDao.getById(id1));
//
//        Long id2= (Long) userDao.save(user2);
//        assertNotNull(id2);
//        assertEquals(user2,userDao.getById(id2));
//
//        Long id3= (Long) userDao.save(user3);
//        assertNotNull(id3);
//        assertEquals(user3,userDao.getById(id3));
//
//        //测试getAll
//        List<User> users=userDao.getAll();
//        assertEquals(users.size(),3);
//        assertTrue(users.contains(user1));
//        assertTrue(users.contains(user2));
//        assertTrue(users.contains(user3));
//
//        //测试getByIds
//        List<User> partialUsers=userDao.getByIds(new Long[]{id1,id3});
//        assertEquals(partialUsers.size(), 2);
//        assertTrue(users.contains(user1));
//        assertTrue(users.contains(user3));
//
//
//        //测试getById和Update
//        User fetched=userDao.getById(id1);
//        assertNotNull(fetched);
//        assertEquals(fetched, user1);
//        fetched.setName("Bobo");
//        userDao.save(fetched);
//        fetched=userDao.getById(id1);
//        assertEquals(fetched.getName(),"Bobo");
//
//
//        //测试删除
//        userDao.delete(id1);
//        assertEquals(userDao.getAll().size(),2);
//        assertNull(userDao.getById(id1));
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