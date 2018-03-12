package com.kassandra.integration.news.config;

import com.kassandra.integration.news.service.NewsIntegrationService;
import com.kassandra.util.SystemConfigurationUtil;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Onur Karaduman
 * @since 04.08.17
 */
@Configuration
public class NewsRetrofitConfig {

    @Value("app.news.api.key")
    private String NEWS_ENV_VAR;
    private static String NEWS_API_KEY = "apiKey";

    @Bean
    public NewsIntegrationService newsIntegrationService() {
        Retrofit retr = retrofit(okHttpClient());
        return retr.create(NewsIntegrationService.class);
    }

    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient();

        Logger logger = LoggerFactory.getLogger("LoggingInterceptor");

        String apiKey = SystemConfigurationUtil.getVariable(NEWS_ENV_VAR, "03acba78609d495c872d43c14ffc046a");
        if (apiKey == null)
            throw new IllegalArgumentException("Please set the following environment variable with news api key:" + NEWS_ENV_VAR);

        client.interceptors().add(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder().
                    header(NEWS_API_KEY, apiKey).build();

            long t1 = System.nanoTime();

            logger.info(String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            logger.info(String.format("Recieved response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        });
        return client;
    }

    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://api.hurriyet.com.tr/v1/")
                .client(client)
                .build();
    }


}
