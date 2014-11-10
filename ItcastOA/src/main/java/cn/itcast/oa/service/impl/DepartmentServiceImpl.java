package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Service("departmentService")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

    public List<Department> findTopList() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Department d where d.parent IS NULL")
                .list();
    }

    public List<Department> getChildren(Long parentId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Department d where d.parent.id=?")
                .setParameter(0, parentId)
                .list();
    }
}
