package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 * Created by lkk on 2014/11/10.
 */
@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
    public User getByLoginNameAndPassword(String loginName, String password) {
        String md5Digest= DigestUtils.md5Hex(password);
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.loginName=? and u.password=?")
                .setParameter(0, loginName)
                .setParameter(1, md5Digest)
                .uniqueResult();
    }
}
