package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

import java.util.List;

/**
 * Created by lkk on 2014/11/14.
 */
public interface ReplyService extends DaoSupport<Reply>{
    List<Reply> findByTopic(Topic topic);
}
