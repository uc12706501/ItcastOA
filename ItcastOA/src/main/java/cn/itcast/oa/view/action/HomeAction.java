package cn.itcast.oa.view.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

/**
 * Created by lkk on 2014/11/12.
 */
@Controller
public class HomeAction extends ActionSupport {

    public String index() {
        return "index";
    }

    public String left() {
        return "left";
    }

    public String right() {
        return "right";
    }

    public String top() {
        return "top";
    }

    public String bottom() {
        return "bottom";
    }

}
