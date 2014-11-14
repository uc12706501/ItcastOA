package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

import java.util.List;

/**
 * Created by lkk on 2014/11/14.
 */
public interface TopicService extends DaoSupport<Topic> {
    List findByForum(Forum forum);
}