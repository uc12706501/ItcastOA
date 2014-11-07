package cn.itcast.oa.view.action;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport {

    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public void setId(Long id) {
        this.id = id;
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
        ActionContext.getContext().put("list", roles);
        return "list";
    }

    /**
     * 删除
     *
     * @return
     */
    public String delete() {
        roleService.delete(id);
        return "toList";
    }

    /**
     * 添加页面
     *
     * @return
     */
    public String addUI() {
        return "addUI";
    }

    /**
     * 添加
     *
     * @return
     */
    public String add() {
        Role role=new Role();
        role.setName(name);
        role.setDescription(description);
        roleService.save(role);
        return "toList";
    }

    /**
     * 修改页面
     *
     * @return
     */
    public String editUI() {
        Role role=roleService.getById(id);
        ActionContext.getContext().getValueStack().push(role);
        return "editUI";
    }

    /**
     * 修改
     *
     * @return
     */
    public String edit() {
        Role role=roleService.getById(id);
        role.setName(name);
        role.setDescription(description);
        roleService.update(role);
        return "toList";
    }
}
