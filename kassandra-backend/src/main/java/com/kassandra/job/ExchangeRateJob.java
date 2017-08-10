package com.kassandra.job;

import com.kassandra.integration.exchangerate.model.ExchangeRate;
import com.kassandra.integration.exchangerate.service.ExchangeRateIntegrationService;
import com.kassandra.service.ExchangeRateService;
import com.kassandra.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
@Service
public class ExchangeRateJob implements Job {

    private static String START_DATE = "2006-01-01";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Autowired
    private ExchangeRateIntegrationService exchangeRateIntegrationService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    //@Scheduled(cron = "*/2 * * * * *")
    @Override
    public void execute() throws IOException {
        Date lastUpdateDate = exchangeRateService.getLastUpdateDate();
        DateTime dateTime = null;
        if (lastUpdateDate == null) {
             dateTime = dateTimeFormatter.parseDateTime(START_DATE);
        } else {
            dateTime = new DateTime(DateUtil.oneDayAfter(lastUpdateDate));
        }
        Call<ExchangeRate> exchangeRates = exchangeRateIntegrationService.getExchangeRates(dateTimeFormatter.print(dateTime), "EUR", new String[]{"TRY"});
        Response<ExchangeRate> execute = exchangeRates.execute();
        ExchangeRate body = execute.body();
        exchangeRateService.saveExchangeRate(body.getBase(), body.getRates(), lastUpdateDate);
    }
}
