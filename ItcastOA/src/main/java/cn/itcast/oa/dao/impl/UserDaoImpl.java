package cn.itcast.oa.dao.impl;

import cn.itcast.oa.base.DaoBaseImpl;
import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by lkk on 2014/11/6.
 */

@Component("userDao")
public class UserDaoImpl extends DaoBaseImpl<User> implements UserDao {
}
