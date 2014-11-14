package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lkk on 2014/11/14.
 */
@Service
public class
        ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

    public List<Reply> findByTopic(Topic topic) {
        return getSession().createQuery("from Reply r where r.topic=? order by r.postTime")
                .setParameter(0, topic)
                .list();
    }

    @Override
    public void save(Reply entity) {
        getSession().save(entity);

        //维护相关属性
        Topic topic=entity.getTopic();
        Forum forum=topic.getForum();

        forum.setArticleCount(forum.getArticleCount()+1);
        topic.setReplyCount(topic.getReplyCount()+1);
        topic.setLastReply(entity);
        topic.setLastUpdateTime(entity.getPostTime());

        getSession().update(topic);
        getSession().update(forum);

    }
}
