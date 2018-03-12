package com.kassandra.service.currency;

import com.kassandra.integration.exchangerate.service.ExchangeRateIntegrationService;
import com.kassandra.repository.domain.ExchangeRate;
import com.kassandra.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import retrofit.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("ExchangeRateRealTimeService")
public class ExchangeRateRealTimeService implements ExchangeRateService {

    @Autowired
    private ExchangeRateIntegrationService exchangeRateIntegrationService;

    @Override
    public List<ExchangeRate> getExchangeRatesByDate(String currency, String referenceCurrency, Date date) {
        com.kassandra.integration.exchangerate.model.ExchangeRate exchangeRate = null;
        try {
            exchangeRate = getExchangeRate(currency, referenceCurrency, date);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adapt(exchangeRate, date);
    }

    @Override
    public List<ExchangeRate> getExchangeRatesBetweenDates(String currency, String referenceCurrency, Date startDate, Date endDate) {
        Date dateTmp = startDate;
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        while (dateTmp.compareTo(endDate) <= 0) {
            try {
                com.kassandra.integration.exchangerate.model.ExchangeRate exchangeRate = getExchangeRate(currency, referenceCurrency, dateTmp);
                if (exchangeRate != null) {
                    List<ExchangeRate> adapt = adapt(exchangeRate, dateTmp);
                    if (adapt != null) {
                        exchangeRates.addAll(adapt);
                    }
                }
                dateTmp = DateUtils.addDays(dateTmp, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exchangeRates;
    }

    @Override
    public List<ExchangeRate> getExchangeRatesByYearAndMonth(String currency, String referenceCurrency, Integer year, Integer month) {
        return null;
    }

    @Override
    public List<ExchangeRate> getLastNMonthExchangeRates(String currency, String referenceCurrency, Integer monthBefore) {
        return null;
    }

    @Override
    public Date getLastUpdateDate() {
        return null;
    }

    @Override
    public void saveExchangeRate(String refCurrencyName, Map<String, Object> currencyMap, Date date) {

    }

    @Override
    public Page<ExchangeRate> list(Pageable pageable) {
        return null;
    }

    @Override
    public ExchangeRate findById(Long id) {
        return null;
    }

    @Override
    public ExchangeRate save(ExchangeRate entity) {
        return null;
    }

    private List<ExchangeRate> adapt(com.kassandra.integration.exchangerate.model.ExchangeRate exchangeRateParam, Date date) {
        if (exchangeRateParam == null) {
            return null;
        }
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (Map.Entry<String, Object> cur : exchangeRateParam.getRates().entrySet()) {
            ExchangeRate exchangeRate = new ExchangeRate();
            exchangeRate.setCurrency(exchangeRate.getCurrency());
            exchangeRate.setReferenceCurrency(exchangeRate.getReferenceCurrency());
            exchangeRate.setDate(date);
            exchangeRate.setValue((Double) cur.getValue());
            exchangeRates.add(exchangeRate);
        }
        return exchangeRates;
    }

    private com.kassandra.integration.exchangerate.model.ExchangeRate getExchangeRate(String cur, String refCur, Date date) throws IOException {
        DateTime dt = new DateTime(date);
        Call<com.kassandra.integration.exchangerate.model.ExchangeRate> exchangeRates = exchangeRateIntegrationService.getExchangeRates(DateUtil.DATE_FORMATTER2.print(dt), refCur, new String[]{cur});
        return exchangeRates.execute().body();
    }

}
