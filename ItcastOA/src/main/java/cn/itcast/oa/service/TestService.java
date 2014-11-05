package cn.itcast.oa.service;

import cn.itcast.oa.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkk on 2014/11/5.
 */
@Component
public class TestService {
    @Resource
    public SessionFactory sessionFactory;

    @Transactional
    public void AddTwoUserSuccess(){
        Session session=sessionFactory.getCurrentSession();
        User user1=new User();
        User user2=new User();
        session.save(user1);
        session.save(user2);
    }

    @Transactional
    public void AddTwoUserFail(){
        Session session=sessionFactory.getCurrentSession();
        User user=new User();
        session.save(user);
        int i=1/0;
        session.save(user);
    }

    @Transactional
    public Long SumUser(){
        Session session=sessionFactory.getCurrentSession();
        List result= session.createQuery("select count(user) from cn.itcast.oa.domain.User user").list();
        return (Long)result.get(0);
    }
}
