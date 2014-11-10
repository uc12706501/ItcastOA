package cn.itcast.oa.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
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

    public java.io.Serializable save(T entity) {
        return sessionFactory.getCurrentSession().save(entity);
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
        return getSession().createQuery("from " + clazz.getSimpleName() + " where id in (:ids)")
                .setParameterList("ids", ids)
                .list();
    }
}
