package cn.itcast.oa.base;

import cn.itcast.oa.util.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * Created by lkk on 2014/11/6.
 */
@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T> {

    @Resource
    protected
    SessionFactory sessionFactory;
    private Class<T> clazz = null;

    public DaoSupportImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Long id) {
        getSession().delete(getById(id));
    }

    public void update(T eneity) {
        getSession().update(eneity);
    }

    public T getById(Long id) {
        return (T) getSession().get(clazz, id);
    }

    public List<T> getAll() {
        return getSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    public List<T> getByIds(Long[] ids) {
        if (ids == null || ids.length == 0)
            return Collections.EMPTY_LIST;
        return getSession().createQuery("from " + clazz.getSimpleName() + " where id in (:ids)")
                .setParameterList("ids", ids)
                .list();
    }

    public PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters) {

        //查询数据
        Query listQuery = getSession().createQuery(hql);
        if (parameters != null && parameters.size() != 0) {
            for (int i = 0; i < parameters.size(); i++) {
                listQuery.setParameter(i, parameters.get(i));
            }
        }

        listQuery.setMaxResults(pageSize);
        listQuery.setFirstResult((pageNum - 1) * pageSize);
        List recordList = listQuery.list();

        //查询总记录数
        Query countQuery = getSession().createQuery("select count(*) "+hql);
        if (parameters != null && parameters.size() != 0) {
            for (int i = 0; i < parameters.size(); i++) {
                countQuery.setParameter(i, parameters.get(i));
            }
        }
        Long recordCount = (Long) countQuery.uniqueResult();
        return new PageBean(pageSize, pageNum, recordList, recordCount.intValue());
    }
}
