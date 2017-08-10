package com.kassandra.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Getter
@Setter
public class NewsDto implements BaseDto {

    private String url;

    private String title;

    private String content;

    private Date date;
}
