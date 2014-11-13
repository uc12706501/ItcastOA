package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lkk on 2014/11/13.
 */
@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

    public void moveUp(Long id) {

    }

    public void moveDown(Long id) {

    }

}
