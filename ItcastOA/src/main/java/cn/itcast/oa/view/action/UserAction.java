package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtil;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;

/**
 * Created by lkk on 2014/11/10.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private Long departmentId;
    private Long[] roleids;
    private Long parentId;

    /**
     * 列表
     */
    public String list() throws Exception {
        List<User> userList = userService.getAll();
        ActionContext.getContext().put("userList", userList);
        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        userService.delete(model.getId());
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
        //准备数据，departmentList
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtil.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);
        //准备数据，roleList
        List<Role> roleList = roleService.getAll();
        ActionContext.getContext().put("roleList", roleList);

        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {

        //设置默认密码
        model.setPassword("1234");

        //设置复杂属性
        Department department = departmentService.getById(departmentId);
        model.setDepartment(department);

        List<Role> roleList = roleService.getByIds(roleids);
        model.setRoles(new HashSet<Role>(roleList));

        //保存到数据库中
        userService.save(model);

        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {

        //准备数据，departmentList
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtil.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);
        //准备数据，roleList
        List<Role> roleList = roleService.getAll();
        ActionContext.getContext().put("roleList", roleList);

        //回显数据
        User user = userService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(user);

        if (user.getDepartment() != null)
            departmentId = user.getDepartment().getId();
        if (user.getRoles() != null) {
            int index = 0;
            roleids = new Long[user.getRoles().size()];
            for (Role role : user.getRoles()) {
                roleids[index] = role.getId();
                index++;
            }
        }

        return "saveUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        //获得对象
        User user = userService.getById(model.getId());

        //设置对象
        //>>设置一般属性
        user.setLoginName(model.getLoginName());
        user.setName(model.getName());
        user.setGender(model.getGender());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setEmail(model.getEmail());
        user.setDescription(model.getDescription());
        user.setPassword(DigestUtils.md5Hex("1234"));


        //>>设置复杂属性
        if (departmentId != null) {
            Department department = departmentService.getById(departmentId);
            user.setDepartment(department);
        }

        List<Role> roleList = roleService.getByIds(roleids);
        user.setRoles(new HashSet<Role>(roleList));

        //保存到数据库中
        userService.save(user);

        return "toList";

    }

    /**
     * 修改密码
     *
     * @return
     */
    public String initPassword() {
        User user = userService.getById(model.getId());
        user.setPassword(DigestUtils.md5Hex("1234"));
        userService.update(user);
        return "toList";
    }

    /**
     * 登陆页面
     *
     * @return
     */
    public String loginUI() {
        return "loginUI";
    }

    /**
     * 登陆
     *
     * @return
     */
    public String login() {
        User user = userService.getByLoginNameAndPassword(model.getLoginName(), model.getPassword());
        if (user == null) {
            addFieldError("", "用户名与密码不匹配");
            return "loginUI";
        } else {
            ActionContext.getContext().getSession().put("user", user);
        }

        return "toIndex";
    }

    /**
     * 退出
     *
     * @return
     */
    public String logout() {
        ActionContext.getContext().getSession().remove("user");
        return "logout";
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long[] getRoleids() {
        return roleids;
    }

    public void setRoleids(Long[] roleids) {
        this.roleids = roleids;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
