package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lkk on 2014/11/14.
 */
@Service
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {
    public List<Topic> findByForum(Forum forum) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc ,t.lastUpdateTime desc")
                .setParameter(0, forum)
                .list();
    }

    @Override
    public void save(Topic entity) {
        //设置属性
        entity.setType(Topic.TYPE_NORMAL);
        entity.setReplyCount(0);
        entity.setLastReply(null);
        entity.setLastUpdateTime(entity.getPostTime());

        //维护其他对象的特殊属性
        Forum forum = entity.getForum();
        forum.setTopicCount(forum.getTopicCount() + 1);
        forum.setArticleCount(forum.getArticleCount() + 1);
        forum.setLastTopic(entity);

        sessionFactory.getCurrentSession().save(entity);
        sessionFactory.getCurrentSession().save(forum);
    }
}
