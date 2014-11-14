package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by lkk on 2014/11/14.
 */
@Controller
@Scope("prototype")
public class ForumAction {
    /**
     * 查看主题列表
     *
     * @return
     */
    public String list() {
        return "list";
    }

    /**
     * 查看主题
     *
     * @return
     */
    public String show() {
        return "show";
    }


}
