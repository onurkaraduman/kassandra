package com.kassandra.integration.news.service;

import com.kassandra.integration.news.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit.Call;
import retrofit.Response;

import java.util.List;

/**
 * Created by onur on 10.08.17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
public class NewsIntegrationServiceWrapperTest {


    @Autowired
    private NewsIntegrationServiceWrapper newsIntegrationService;

    @Test
    public void getNewsByModifiedDate() throws Exception {
        Call<List<News>> newsByModifiedDate = newsIntegrationService.getNewsByModifiedDate("2014-01-01");
        Response<List<News>> execute = newsByModifiedDate.execute();
        List<News> body = execute.body();
    }

}