package cn.itcast.oa.service.impl;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    public void delete(Long id) {
        departmentDao.delete(id);
    }

    public void save(Department department) {
        departmentDao.save(department);
    }

    public Department getById(Long id) {
        return departmentDao.getById(id);
    }

    public void updata(Department department) {
        departmentDao.update(department);
    }
}
