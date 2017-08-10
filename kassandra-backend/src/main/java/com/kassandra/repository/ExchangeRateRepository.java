package com.kassandra.repository;

import com.kassandra.repository.domain.Currency;
import com.kassandra.repository.domain.ExchangeRate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Database operation for {@link ExchangeRate}
 *
 * @author Onur Karaduman
 * @since 13.07.17
 */
@Repository
public interface ExchangeRateRepository extends com.kassandra.repository.Repository<ExchangeRate, Long> {

    public List<ExchangeRate> findByCurrencyAndReferenceCurrencyAndDate(Currency currency,
                                                                        Currency referenceCurrency,
                                                                        Date date);
    @Query("select Max(e.date) from ExchangeRate e order by e.date desc ")
    public Date getLastUpdateDate();
}
