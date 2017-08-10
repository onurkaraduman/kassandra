package com.kassandra.job;

import com.kassandra.integration.exchangerate.model.ExchangeRate;
import com.kassandra.integration.exchangerate.model.Rates;
import com.kassandra.integration.exchangerate.service.ExchangeRateIntegrationService;
import com.kassandra.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
@Service
public class CurrencyJob implements Job {


    @Autowired
    private ExchangeRateIntegrationService exchangeRateIntegrationService;

    @Autowired
    private CurrencyService currencyService;

    @Scheduled(cron = "*/2 * * * * *")
    @Override
    public void execute() throws IOException {
        Call<ExchangeRate> allExchangeRates = exchangeRateIntegrationService.getAllExchangeRates("EUR");
        Response<ExchangeRate> exchangeRateResponse = allExchangeRates.execute();
        ExchangeRate exchangeRate = exchangeRateResponse.body();
        Map<String, Object> properties = exchangeRate.getRates();
        properties.put(exchangeRate.getBase(), null);
        currencyService.saveCurrencies(new ArrayList<>(properties.keySet()));
    }
}
