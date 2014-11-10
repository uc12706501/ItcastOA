package cn.itcast.oa.util;

import cn.itcast.oa.domain.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lkk on 2014/11/10.
 */
public class DepartmentUtil {
    public static List<Department> getAllDepartments(List<Department> topList) {
        List<Department> departmentList = new ArrayList<Department>();
        walkDepartmentListTree(topList, "┣", departmentList);
        return departmentList;
    }

    private static void walkDepartmentListTree(Collection<Department> toplist, String prefix, List<Department> list) {
        for (Department department : toplist) {
            Department copy = new Department();
            copy.setId(department.getId());
            copy.setName(prefix + department.getName());
            list.add(copy);
            walkDepartmentListTree(department.getChildren(), "　" + prefix, list);
        }
    }
}
