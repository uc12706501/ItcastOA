package cn.itcast.oa.view.action;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
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
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

    private Role role=new Role();

    public Role getModel() {
        return role;
    }


    @Resource
    public RoleService roleService;

    /**
     * 列表
     *
     * @return
     */
    public String list() {
        List<Role> roles = roleService.getAll();
        ActionContext.getContext().put("roleList", roles);
        return "list";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        roleService.delete(role.getId());
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
        roleService.save(role);
        return "toList";
    }

    /**
     * 修改页面
     *
     * @return
     */
    public String editUI() {
        role=roleService.getById(role.getId());
        ActionContext.getContext().getValueStack().push(role);
        return "saveUI";
    }

    /**
     * 修改
     *
     * @return
     */
    public String edit() {
        roleService.update(role);
        return "toList";
    }


}
