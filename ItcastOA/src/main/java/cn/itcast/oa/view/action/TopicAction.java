package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by lkk on 2014/11/14.
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

    private Long forumId;

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
        Forum forum = forumService.getById(forumId);
        ActionContext.getContext().put("forum", forum);

        return "addUI";
    }

    /**
     * 添加主题
     *
     * @return
     */
    public String add() {
        //封装好的参数
        //model.setContent();
        //model.setTitle();
        model.setForum(forumService.getById(forumId));

        model.setPostTime(new Date());
        model.setAuthor(getCurrentUser());
        model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());

        topicService.save(model);
        return "toShow";
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }
}
