package com.kassandra.service.currency;

import com.kassandra.repository.domain.ExchangeRate;
import com.kassandra.service.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ExchangeRateService extends Service<ExchangeRate> {
    List<ExchangeRate> getExchangeRatesByDate(String currency,
                                              String referenceCurrency,
                                              Date date);

    List<ExchangeRate> getExchangeRatesBetweenDates(String currency,
                                                    String referenceCurrency,
                                                    Date startDate,
                                                    Date endDate);

    List<ExchangeRate> getExchangeRatesByYearAndMonth(String currency,
                                                      String referenceCurrency,
                                                      Integer year,
                                                      Integer month);

    List<ExchangeRate> getLastNMonthExchangeRates(String currency,
                                                  String referenceCurrency,
                                                  Integer monthBefore);

    Date getLastUpdateDate();

    void saveExchangeRate(String refCurrencyName, Map<String, Object> currencyMap, Date date);
}
