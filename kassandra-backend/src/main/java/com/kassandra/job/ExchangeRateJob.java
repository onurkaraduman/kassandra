package com.kassandra.job;

import com.kassandra.integration.exchangerate.model.ExchangeRate;
import com.kassandra.integration.exchangerate.service.ExchangeRateIntegrationService;
import com.kassandra.service.currency.ExchangeRateDbService;
import com.kassandra.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;
import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
@ManagedResource
@Service
@EnableScheduling
public class ExchangeRateJob implements Job {

    private static String START_DATE = "2006-01-01";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Autowired
    private ExchangeRateIntegrationService exchangeRateIntegrationService;

    @Autowired
    private ExchangeRateDbService exchangeRateService;

    private void update() throws IOException {
        Date lastUpdateDate = exchangeRateService.getLastUpdateDate();
        DateTime dateTime = null;
        if (lastUpdateDate == null) {
            dateTime = dateTimeFormatter.parseDateTime(START_DATE);
        } else {
            if (DateUtil.compareDateOnly(lastUpdateDate, new Date()) == 0) {
                return;
            }
            dateTime = new DateTime(DateUtil.oneDayAfter(lastUpdateDate));
        }
        Call<ExchangeRate> exchangeRates = exchangeRateIntegrationService.getExchangeRates(dateTimeFormatter.print(dateTime), "EUR", new String[]{"TRY"});
        Response<ExchangeRate> execute = exchangeRates.execute();
        ExchangeRate body = execute.body();
        if (body != null && body.getRates().size() > 0)
            exchangeRateService.saveExchangeRate(body.getBase(), body.getRates(), dateTime.toDate());
    }

    @Scheduled(cron = "*/2 * * * * *")
    @ManagedOperation
    @Override
    public void execute() throws IOException {
        for (int i = 0; i < 1000; i++) {
            update();
        }
    }
}
