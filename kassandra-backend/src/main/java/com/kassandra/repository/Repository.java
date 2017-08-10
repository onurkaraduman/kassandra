package com.kassandra.repository;

import com.kassandra.repository.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * This interface is the custom base repository extended {@link JpaRepository}
 * This interface should be extended by all repositories
 *
 * @author Onur Karaduman
 * @since 13.07.17
 */
@NoRepositoryBean
public interface Repository<T extends AbstractEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
