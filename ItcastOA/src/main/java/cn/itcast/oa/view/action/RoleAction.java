package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    private Long[] privilegeIds;

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
        roleService.delete(model.getId());
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
        roleService.save(model);
        return "toList";
    }

    /**
     * 修改页面
     *
     * @return
     */
    public String editUI() {
        model = roleService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(model);
        return "saveUI";
    }

    /**
     * 修改
     *
     * @return
     */
    public String edit() {
        roleService.update(model);
        return "toList";
    }

    /**
     * 设置权限页面
     *
     * @return
     */
    public String setPrivilegesUI() {
        //准备数据
        List<Privilege> privilegeList = privilegeService.getAll();
        ActionContext.getContext().put("privilegeList", privilegeList);

        //回显数据
        Role role = roleService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);
        if (role.getPrivileges() != null && role.getPrivileges().size() != 0)
            privilegeIds = new Long[role.getPrivileges().size()];
        int index = 0;
        for (Privilege privilege : role.getPrivileges()) {
            privilegeIds[index] = privilege.getId();
            index++;
        }

        return "setPrivilegesUI";
    }

    /**
     * 设置权限
     *
     * @return
     */
    public String setPrivileges() {
        //获取对象
        Role role = roleService.getById(model.getId());

        //修改对象
        List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
        role.setPrivileges(new HashSet<Privilege>(privilegeList));

        //保存对象
        roleService.update(role);

        return "toList";
    }

    public Long[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Long[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }
}
