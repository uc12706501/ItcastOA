package cn.itcast.oa.service;

import cn.itcast.oa.domain.Department;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
public interface DepartmentService {
    List<Department> getAll();

    void delete(Long id);

    void save(Department department);

    Object getById(Long id);

    void updata(Department department);
}
