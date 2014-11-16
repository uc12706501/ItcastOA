package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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

//        PageBean pageBean = topicService.getPageBeanByForum(pageNum, pageSize, forum);
//        ActionContext.getContext().getValueStack().push(pageBean);
        String hql = "FROM Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc ,t.lastUpdateTime desc";
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(forum);

        PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql, parameters);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "show";
    }

}
