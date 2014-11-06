package cn.itcast.oa.view.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by lkk on 2014/11/4.
 */
@Component("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
