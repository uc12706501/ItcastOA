package cn.itcast.oa.service.impl;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lkk on 2014/11/11.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {
}
