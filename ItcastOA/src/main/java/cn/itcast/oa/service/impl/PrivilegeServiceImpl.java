package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lkk on 2014/11/11.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {
    public List<Privilege> findTopPrivileges() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Privilege p where p.parent is null")
                .list();
    }

    public List<String> findAllPrivileges() {
        return sessionFactory.getCurrentSession()
                .createQuery(" select distinct p.url  from Privilege p where p.url is not null")
                .list();
    }
}
