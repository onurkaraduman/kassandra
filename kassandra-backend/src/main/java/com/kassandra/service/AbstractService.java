package com.kassandra.service;

import com.kassandra.repository.Repository;
import com.kassandra.repository.domain.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Onur Karaduman
 * @since 13.07.17
 */
public abstract class AbstractService<T extends AbstractEntity> implements Service<T> {

    public abstract Repository getRepository();

    public Page<T> list(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T findById(Long id) {
        return (T) getRepository().findOne(id);
    }

    public T save(T entity) {
        return (T) getRepository().save(entity);
    }
}
