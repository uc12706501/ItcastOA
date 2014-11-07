package cn.itcast.oa.dao.impl;

import cn.itcast.oa.base.DaoBaseImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import org.springframework.stereotype.Component;

/**
 * Created by lkk on 2014/11/7.
 */
@Component("departmentDao")
public class DepartmentDaoImpl extends DaoBaseImpl<Department> implements DepartmentDao {
}
