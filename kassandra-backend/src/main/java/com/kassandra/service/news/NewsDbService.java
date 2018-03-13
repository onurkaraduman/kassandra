package com.kassandra.service.news;

import com.kassandra.repository.NewsRepository;
import com.kassandra.repository.Repository;
import com.kassandra.repository.domain.News;
import com.kassandra.service.AbstractService;
import com.kassandra.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Service("NewsDbService")
public class NewsDbService extends AbstractService<News> implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Repository getRepository() {
        return this.newsRepository;
    }


    public List<News> getNewsByDate(Date date) {
        return getNewsByDate(date, DateUtil.oneDayAfter(date));
    }

    public List<News> getNewsByDate(Date startDate, Date endDate) {
        return this.newsRepository.findByDateBetween(startDate, endDate);
    }

    public Date getLastNewsDate() {
        return this.newsRepository.getLastNewsDate();
    }

    public void save(List<News> newsList) {
        for (News news : newsList) {
            if (!isExist(news.getNewsId()))
                this.save(news);
        }
    }

    public boolean isExist(String newsId) {
        News newsOne = findByNewsId(newsId);
        return newsOne == null ? false : true;
    }

    public News findByNewsId(String id) {
        return this.newsRepository.findByNewsId(id);
    }
}
