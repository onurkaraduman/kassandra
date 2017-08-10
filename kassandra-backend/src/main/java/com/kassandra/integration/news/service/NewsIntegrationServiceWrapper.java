package com.kassandra.integration.news.service;

import com.kassandra.integration.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit.Call;

import java.util.List;

/**
 * @author Onur Karaduman
 * @since 10.08.17
 */
@Service
public class NewsIntegrationServiceWrapper {

    private static String NEWS_CATEGORY = "/gundem/";
    private static String BASE_URL = "https://api.hurriyet.com.tr/v1/";

    @Autowired
    private NewsIntegrationService newsIntegrationService;

    public Call<List<News>> getNewsByModifiedDate(String modifiedDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL);
        sb.append(String.format("articles?$filter=ModifiedDate%%20eq%%20DateTime'%s'", modifiedDate));
        return newsIntegrationService.getNews(sb.toString());
    }

    public Call<List<News>> getNewsByModifiedDate(String startDate, String endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL);
        sb.append(String.format("articles?$filter=ModifiedDate%%20ge%%20DateTime'%s'%%20and%%20ModifiedDate%%20le%%20DateTime'%s'%%20and%%20Path%%20eq%%20'%s'", startDate, endDate, NEWS_CATEGORY));
        return newsIntegrationService.getNews(sb.toString());
    }
}
