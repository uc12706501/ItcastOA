package cn.itcast.oa.view.action;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    @Resource
    private DepartmentService departmentService;
    private Department department = new Department();

    public Department getModel() {
        return department;
    }

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Department> departmentList=departmentService.getAll();
        ActionContext.getContext().put("departmentList",departmentList);
        return "list";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        departmentService.delete(department.getId());
        return "toList";
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        return "saveUI";
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        departmentService.save(department);
        return "toList";
    }

    /**
     * 修改
     *
     * @return
     */
    public String editUI() {
        ActionContext.getContext().getValueStack().push(departmentService.getById(department.getId()));
        return "saveUI";
    }

    /**
     * 修改页面
     *
     * @return
     */
    public String edit() {
        departmentService.updata(department);
        return "toList";
    }

}
