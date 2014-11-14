package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by lkk on 2014/11/14.
 */

@Controller
@Scope("prototype")
public class ReplyAction {

    /**
     * 添加回复页面
     * @return
     */
    public String addUI(){
        return "addUI";
    }

    /**
     * 添加回复
     * @return
     */
    public String add(){
        return "toTopicShow";
    }
}
