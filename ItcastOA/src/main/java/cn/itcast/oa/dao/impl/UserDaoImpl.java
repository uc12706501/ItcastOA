package cn.itcast.oa.dao.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by lkk on 2014/11/6.
 */

@Component("userDao")
@Deprecated
public class UserDaoImpl extends DaoSupportImpl<User> implements UserDao {
}
