package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by lkk on 2014/11/14.
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

    /**
     * 查看主题列表
     *
     * @return
     */
    public String list() {
        List<Forum> forumList = forumService.getAll();
        ActionContext.getContext().put("forumList", forumList);
        return "list";
    }

    /**
     * 查看主题
     *
     * @return
     */
    public String show() {
        //准备数据
        Forum forum = forumService.getById(model.getId());
        ActionContext.getContext().put("forum", forum);

        List<Topic> topicList = topicService.findByForum(forum);
        ActionContext.getContext().put("topicList", topicList);
        return "show";
    }

}
