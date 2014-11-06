package cn.itcast.oa.dao.impl;

import cn.itcast.oa.base.DaoBaseImpl;
import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.domain.Role;
import org.springframework.stereotype.Service;

/**
 * Created by lkk on 2014/11/6.
 */
@Service("roleDao")
public class RoleDaoImpl extends DaoBaseImpl<Role> implements RoleDao {
}
