package cn.itcast.oa.dao.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import org.springframework.stereotype.Component;

/**
 * Created by lkk on 2014/11/7.
 */
@Component("departmentDao")
@Deprecated
public class DepartmentDaoImpl extends DaoSupportImpl<Department> implements DepartmentDao {
}
