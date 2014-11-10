package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Department;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
public interface DepartmentService extends DaoSupport<Department> {
    List<Department> findTopList();

    List<Department> getChildren(Long parentId);
}
