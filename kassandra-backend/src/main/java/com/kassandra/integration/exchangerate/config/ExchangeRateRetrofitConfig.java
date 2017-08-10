package com.kassandra.integration.exchangerate.config;

import com.kassandra.integration.exchangerate.service.ExchangeRateIntegrationService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Onur Karaduman
 * @since 04.08.17
 */
@Configuration
public class ExchangeRateRetrofitConfig {


    @Bean
    public ExchangeRateIntegrationService exchangeRateIntegrationService() {
        Retrofit retr = retrofit(okHttpClient());
        return retr.create(ExchangeRateIntegrationService.class);
    }

    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient();

        Logger logger = LoggerFactory.getLogger("LoggingInterceptor");

        client.interceptors().add(chain -> {
            Request request = chain.request();

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
                .baseUrl("http://api.fixer.io/")
                .client(client)
                .build();
    }
}
