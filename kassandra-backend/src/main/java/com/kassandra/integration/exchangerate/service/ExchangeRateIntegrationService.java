package com.kassandra.integration.exchangerate.service;

import com.kassandra.integration.exchangerate.model.ExchangeRate;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

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
