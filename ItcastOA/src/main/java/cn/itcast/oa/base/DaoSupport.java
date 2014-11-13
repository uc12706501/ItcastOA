package cn.itcast.oa.base;

import java.util.List;

/**
 * Created by lkk on 2014/11/6.
 */
public interface DaoSupport<T> {
    /**
     * 保存实体
     * @param entity
     */
    void save(T entity);

    /**
     * 删除实体
     * @param entity
     */
    void delete(Long entity);

    /**
     * 更新实体
     * @param eneity
     */
    void update(T eneity);

    /**
     * 根据id查找实体
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 获得所有实体
     * @return
     */
    List<T> getAll();

    /**
     * 根据ids查找实体
     * @param ids
     * @return
     */
    List<T> getByIds(Long[] ids);
}
