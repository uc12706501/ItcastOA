package cn.itcast.oa.service.impl;

import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Repository("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    public List<Role> getAll() {
        return roleDao.getAll();
    }

    public void delete(Long id) {
        roleDao.delete(id);
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    public void update(Role role) {
        roleDao.update(role);
    }
}
