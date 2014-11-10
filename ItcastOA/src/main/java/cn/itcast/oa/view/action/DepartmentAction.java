package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.util.DepartmentUtil;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

    private Long parentId;

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Department> departmentList;
        if (parentId == null)
            departmentList = departmentService.findTopList();
        else {
            Department parent = departmentService.getById(parentId);
            departmentList = departmentService.getChildren(parentId);
        }

        ActionContext.getContext().put("departmentList", departmentList);
        return "list";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        departmentService.delete(model.getId());
        return "toList";
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtil.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);
        return "saveUI";
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        if (parentId != null)
            model.setParent(departmentService.getById(parentId));
        departmentService.save(model);
        return "toList";
    }

    /**
     * 修改
     *
     * @return
     */
    public String editUI() {
        ActionContext.getContext().getValueStack().push(departmentService.getById(model.getId()));

        List<Department> departmentList = departmentService.getAll();
        ActionContext.getContext().put("departmentList", departmentList);
        if (model.getParent() != null)
            parentId = model.getParent().getId();

        return "saveUI";
    }

    /**
     * 修改页面
     *
     * @return
     */
    public String edit() {
        if (parentId != null)
            model.setParent(departmentService.getById(parentId));
        departmentService.update(model);
        return "toList";
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
