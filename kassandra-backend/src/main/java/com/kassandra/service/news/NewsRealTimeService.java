package com.kassandra.service.news;

import com.kassandra.integration.news.service.NewsIntegrationServiceWrapper;
import com.kassandra.job.adapter.NewsAdapter;
import com.kassandra.repository.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("NewsRealTimeService")
public class NewsRealTimeService implements NewsService {

    @Autowired
    private NewsIntegrationServiceWrapper integrationServiceWrapper;


    @Override
    public Page<News> list(Pageable pageable) {
        return null;
    }

    @Override
    public News findById(Long id) {
        return null;
    }

    @Override
    public News save(com.kassandra.repository.domain.News entity) {
        return null;
    }


    @Override
    public List<com.kassandra.repository.domain.News> getNewsByDate(Date date) {
        List<com.kassandra.repository.domain.News> newsList = new ArrayList<>();
        try {
            Call<List<com.kassandra.integration.news.model.News>> newsByModifiedDate = integrationServiceWrapper.getNewsByModifiedDate(date);
            Response<List<com.kassandra.integration.news.model.News>> news = newsByModifiedDate.execute();
            if (news.body() != null && !news.body().isEmpty()) {
                newsList.addAll(NewsAdapter.adapt(news.body()));
            }
        } catch (IOException e) {

        }
        return newsList;
    }
}
