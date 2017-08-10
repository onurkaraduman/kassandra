package com.kassandra.repository;

import com.kassandra.repository.domain.Currency;
import org.springframework.stereotype.Repository;

/**
 * Database operation for {@link Currency}
 *
 * @author Onur Karaduman
 * @since 13.07.17
 */
@Repository
public interface CurrencyRepository extends com.kassandra.repository.Repository<Currency, Long> {

    public Currency findByName(String name);

}
