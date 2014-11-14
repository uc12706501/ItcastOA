package cn.itcast.oa.base;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.*;
import com.opensymphony.xwork2.ActionContext;
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
    @Resource
    protected ForumService forumService;
    @Resource
    protected TopicService topicService;
    @Resource
    protected ReplyService replyService;

    protected User getCurrentUser(){
        return (User) ActionContext.getContext().getSession().get("user");
    }
}
