package com.kassandra.job;

import com.kassandra.integration.news.model.News;
import com.kassandra.integration.news.service.NewsIntegrationServiceWrapper;
import com.kassandra.job.adapter.NewsAdapter;
import com.kassandra.service.news.NewsDbService;
import com.kassandra.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
@ManagedResource
@Service
@EnableScheduling
public class NewsJob extends AbstractJob {

    private static int MAX_REQUEST_IN_HOUR = 500;
    private static String MAX_REQUEST_IN_HOUR_DEF = "X-RateLimit-Remaining-hour";

    private static String START_DATE = "2006-01-01";


    @Autowired
    @Qualifier("newsIntegrationServiceWrapper")
    private NewsIntegrationServiceWrapper newsIntegrationService;

    @Autowired
    private NewsDbService newsDbService;


    @Scheduled(fixedDelay = 1000)
    @ManagedOperation
    @Override
    public void execute() throws IOException {
        Date lastNewsDate = getLastUpdateDate();
        Response<List<News>> newsResponse = null;
        int remainingHour = MAX_REQUEST_IN_HOUR;
        do {
            newsResponse = getNewsByModifiedDate(lastNewsDate);
            if (newsResponse.body() != null && !newsResponse.body().isEmpty()) {
                List<com.kassandra.repository.domain.News> adaptedNews1 = NewsAdapter.adapt(newsResponse.body());
                newsDbService.save(adaptedNews1);
            }

            lastNewsDate = DateUtil.oneDayAfter(lastNewsDate);
            remainingHour = Integer.parseInt(newsResponse.headers().get(MAX_REQUEST_IN_HOUR_DEF));
        }
        while (remainingHour != 1);

    }

    private Date getLastUpdateDate() {
        Date lastNewsDate = newsDbService.getLastNewsDate();
        if (lastNewsDate == null) {
            lastNewsDate = DateUtil.stringToDate(START_DATE);
        }
        return lastNewsDate;
    }

    private Response<List<News>> getNewsByModifiedDate(Date date) throws IOException {
        Call<List<News>> news = newsIntegrationService.getNewsByModifiedDate(date);
        return news.execute();
    }
}
