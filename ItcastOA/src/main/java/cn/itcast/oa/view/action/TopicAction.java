package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        //准备数据：topic
        Topic topic = topicService.getById(model.getId());
        ActionContext.getContext().put("topic", topic);

        //准备数据：replyList
//        PageBean replyList = replyService.getPageBeamByTopic(pageNum, pageSize, topic);
//        ActionContext.getContext().getValueStack().push(replyList);

        String hql = "from Reply r where r.topic=? order by r.postTime";
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(topic);

        PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
        ActionContext.getContext().getValueStack().push(pageBean);

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
