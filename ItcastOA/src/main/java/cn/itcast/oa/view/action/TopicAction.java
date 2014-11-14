package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by lkk on 2014/11/14.
 */
@Controller
@Scope("prototype")
public class TopicAction {

    /**
     * 查看主题
     *
     * @return
     */
    public String show() {
        return "show";
    }

    /**
     * 添加主题页面
     *
     * @return
     */
    public String addUI() {
        return "addUI";
    }

    /**
     * 添加主题
     *
     * @return
     */
    public String add() {
        return "toShow";
    }
}
