package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
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
public class ReplyAction extends BaseAction<Reply> {

    private Long topicId;

    /**
     * 添加回复页面
     *
     * @return
     */
    public String addUI() {
        Topic topic = topicService.getById(topicId);
        ActionContext.getContext().put("topic", topic);
        return "addUI";
    }

    /**
     * 添加回复
     *
     * @return
     */
    public String add() {
        model.setPostTime(new Date());
        model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        model.setAuthor(getCurrentUser());
        model.setTopic(topicService.getById(topicId));

        replyService.save(model);

        return "toTopicShow";
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
