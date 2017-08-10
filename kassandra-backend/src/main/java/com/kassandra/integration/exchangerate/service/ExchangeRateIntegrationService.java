package com.kassandra.integration.exchangerate.service;

import com.kassandra.integration.common.IntegrationService;
import com.kassandra.integration.exchangerate.model.ExchangeRate;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
public interface ExchangeRateIntegrationService{

    @GET("/latest")
    Call<ExchangeRate> getAllExchangeRates(@Query("base") String refCurrency);

    @GET("/{date}")
    Call<ExchangeRate> getExchangeRates(@Path("date") String date,
                                        @Query("base") String refCurrency,
                                        @Query("symbols") String[] symbols);
}
