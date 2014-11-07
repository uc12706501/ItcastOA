package cn.itcast.oa.service;

import cn.itcast.oa.domain.Role;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
public interface RoleService {
    List<Role> getAll();

    void delete(Long id);

    void save(Role role);

    Role getById(Long id);

    void update(Role role);
}
