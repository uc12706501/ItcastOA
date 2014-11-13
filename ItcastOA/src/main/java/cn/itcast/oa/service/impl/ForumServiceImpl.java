package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lkk on 2014/11/13.
 */
@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

    @Override
    public void save(Forum entity) {
        sessionFactory.getCurrentSession().save(entity);
        entity.setPosition(entity.getId().intValue());
    }

    @Override
    public List<Forum> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Forum f order by f.position")
                .list();
    }

    public void moveUp(Long id) {
        Forum forum = getById(id);
        Forum other = (Forum) sessionFactory.getCurrentSession()
                .createQuery("from Forum f where f.position<? order by f.position DESC")
                .setParameter(0, forum.getPosition())
                .setMaxResults(1)
                .setFirstResult(0)
                .uniqueResult();


        if(other==null)
            return;


        int temp = forum.getPosition();
        forum.setPosition(other.getPosition());
        other.setPosition(temp);

        update(forum);
        update(other);
    }

    public void moveDown(Long id) {
        Forum forum = getById(id);
        Forum other = (Forum) sessionFactory.getCurrentSession()
                .createQuery("from Forum f where f.position>? order by f.position asc")
                .setParameter(0, forum.getPosition())
                .setMaxResults(1)
                .setFirstResult(0)
                .uniqueResult();

        if(other==null)
            return;

        int temp = forum.getPosition();
        forum.setPosition(other.getPosition());
        other.setPosition(temp);

        update(forum);
        update(other);

    }

}
