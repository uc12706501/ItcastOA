package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import org.springframework.stereotype.Repository;

/**
 * Created by lkk on 2014/11/7.
 */
@Repository("roleService")
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

}
