package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lkk on 2014/11/7.
 */
@Repository("roleService")
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

}
