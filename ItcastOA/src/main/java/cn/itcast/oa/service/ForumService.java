package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

/**
 * Created by lkk on 2014/11/13.
 */
public interface ForumService extends DaoSupport<Forum> {
    void moveUp(Long id);

    void moveDown(Long id);

}
