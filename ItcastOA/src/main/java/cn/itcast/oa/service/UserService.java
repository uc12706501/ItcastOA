package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.User;

/**
 * Created by lkk on 2014/11/10.
 */
public interface UserService extends DaoSupport<User>{
    User getByLoginNameAndPassword(String loginName, String password);
}
