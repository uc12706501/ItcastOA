package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Privilege;

import java.util.List;

/**
 * Created by lkk on 2014/11/11.
 */
public interface PrivilegeService extends DaoSupport<Privilege>{
    List<Privilege> findTopPrivileges();
}
