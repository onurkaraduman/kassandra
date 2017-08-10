package com.kassandra.restapi.dto;

import com.kassandra.repository.domain.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Getter
@Setter
public class ExchangeRateDto {

    private Double value;

    private Date date;

    private Currency referenceCurrency;

    private Currency currency;
}
