package cn.itcast.oa.base;

import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

/**
 * Created by lkk on 2014/11/10.
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    //====================对ModelDriven的支持====================
    protected T model;

    public BaseAction() {
        ParameterizedType typeInfo = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class) typeInfo.getActualTypeArguments()[0];
        try {
            model = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public T getModel() {
        return model;
    }

    //====================Service====================
    @Resource
    protected DepartmentService departmentService;
    @Resource
    protected RoleService roleService;
    @Resource
    protected UserService userService;
    @Resource
    protected PrivilegeService privilegeService;

}
