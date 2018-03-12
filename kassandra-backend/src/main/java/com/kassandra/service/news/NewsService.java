package com.kassandra.service.news;

import com.kassandra.repository.domain.News;
import com.kassandra.service.Service;

import java.util.Date;
import java.util.List;

public interface NewsService extends Service<News> {
    public List<com.kassandra.repository.domain.News> getNewsByDate(Date date);
}
