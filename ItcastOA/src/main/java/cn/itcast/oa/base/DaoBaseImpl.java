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
public class DaoBaseImpl<T> implements cn.itcast.oa.base.DaoBase<T> {

    @Resource
    SessionFactory sessionFactory;
    private Class<T> clazz = null;

    public DaoBaseImpl() {
        ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz= (Class<T>) type.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public java.io.Serializable save(T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    @Transactional
    public void delete(Long id) {
        getSession().delete(getById(id));
    }

    @Transactional
    public void update(T eneity) {
        getSession().update(eneity);
    }

    @Transactional
    public T getById(Long id) {
        return (T) getSession().get(clazz, id);
    }

    @Transactional
    public List<T> getAll() {
        return getSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    @Transactional
    public List<T> getByIds(Long[] ids) {
        return getSession().createQuery("from " + clazz.getSimpleName() + " where id in (?:ids)")
                .setParameterList("ids",ids)
                .list();
    }
}
