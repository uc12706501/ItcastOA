package cn.itcast.oa.service.impl;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import org.hibernate.SessionFactory;
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

    @Resource
    private SessionFactory sessionFactory;

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
        if (id == null)
            return null;
        return departmentDao.getById(id);
    }

    public void updata(Department department) {
        departmentDao.update(department);
    }

    public List<Department> findTopList() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Department d where d.parent IS NULL")
                .list();
    }

    public List<Department> getChildren(Long parentId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Department d where d.parent.id=?")
                .setParameter(0,parentId)
                .list();
    }
}
