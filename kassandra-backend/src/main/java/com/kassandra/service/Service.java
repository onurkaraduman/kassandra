package com.kassandra.service;

import com.kassandra.repository.domain.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Onur Karaduman
 * @since 13.07.17
 */
public interface Service<T extends AbstractEntity> {

    /**
     * list all the datas with pagination
     *
     * @return
     */
    public Page<T> list(Pageable pageable);

    /**
     * find the data by id
     *
     * @param id
     * @return
     */
    public T findById(Long id);

    /**
     * save the data
     *
     * @param entity
     * @return
     */
    public T save(T entity);
}
