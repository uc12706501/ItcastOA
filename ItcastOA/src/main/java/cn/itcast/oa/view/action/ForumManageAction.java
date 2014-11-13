package cn.itcast.oa.view.action;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by lkk on 2014/11/13.
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {
    /**
     * 列表
     */
    public String list() throws Exception {
        List<Forum> forumList = forumService.getAll();
        ActionContext.getContext().put("forumList", forumList);
        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        forumService.delete(model.getId());
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {
        forumService.save(model);
        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        //准备回显数据
        Forum forum = forumService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(forum);
        return "saveUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        //获取对象
        Forum forum = forumService.getById(model.getId());

        //修改对象
        forum.setName(model.getName());
        forum.setDescription(model.getDescription());

        //保存对象
        forumService.update(forum);

        return "toList";
    }

    /**
     * 上移
     */
    public String moveUp() throws Exception {
        forumService.moveUp(model.getId());
        return "toList";
    }

    /**
     * 下移
     */
    public String moveDown() throws Exception {
        forumService.moveDown(model.getId());
        return "toList";
    }
}
