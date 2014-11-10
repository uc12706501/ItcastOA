package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by lkk on 2014/11/7.
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

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


}
