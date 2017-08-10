package com.kassandra.integration.news.service;

import com.kassandra.integration.news.model.News;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Url;

import java.util.List;

/**
 * @author Onur Karaduman
 * @since 30.07.17
 */
public interface NewsIntegrationService {
/*
    @GET("articles?$filter=ModifiedDate%20ge%20")
    Call<List<News>> getNews(@Query("DateTime") String modifiedDate);
*/


    @GET
    Call<List<News>> getNews(@Url String url);
}
