package cn.itcast.oa.util;

import cn.itcast.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by lkk on 2014/11/13.
 */
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        String actionName = invocation.getProxy().getActionName();
        String namespace = invocation.getProxy().getNamespace();
        String url = namespace + actionName;

        if (user == null) {
            if (actionName.startsWith("user_login"))
                return invocation.invoke();
            else {
                return "loginUI";
            }
        }
        if (user.findPrivilegeByUrl(url)) {
            return invocation.invoke();
        } else {
            return "noPrivilegeError";
        }
    }
}
