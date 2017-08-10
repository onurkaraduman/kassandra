package com.kassandra.job.adapter;

import com.kassandra.repository.domain.News;
import com.kassandra.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 06.08.17
 */
public class NewsAdapter {

    public static List<News> adapt(List<com.kassandra.integration.news.model.News> newsList) {
        List<News> domNewsList = new ArrayList<>();
        for (com.kassandra.integration.news.model.News news : newsList) {
            domNewsList.add(adapt(news));
        }
        return domNewsList;
    }


    public static News adapt(com.kassandra.integration.news.model.News news) {
        News domNews = new News();
        domNews.setNewsId(news.getId());
        domNews.setTitle(news.getTitle());
        domNews.setDate(DateUtil.stringToDate(news.getModifiedDate()));
        domNews.setUrl(news.getUrl());
        domNews.setCategory(news.getPath().replace("/", ""));
        return domNews;
    }
}
