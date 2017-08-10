package com.kassandra.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract implementation of {@link Entity}
 * All persistent object should be extended from {@link AbstractEntity}
 *
 * @author Onur Karaduman
 * @since 13.07.17
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractEntity implements Entity{

    @Id
    @GeneratedValue
    private Long id;
}
