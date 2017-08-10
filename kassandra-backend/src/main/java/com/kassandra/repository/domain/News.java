package com.kassandra.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * News entity class
 *
 * @author Onur Karaduman
 * @since 08.06.17
 */
@Entity
@Getter
@Setter
public class News extends AbstractEntity {

    @Column(unique = true)
    private String newsId;

    private String url;

    private String title;

    private String content;

    private Date date;

    private String category;
}
