package com.kassandra.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Exchange rate according to reference exchangerate
 *
 * @author Onur Karaduman
 * @since 08.06.17
 */
@Entity
@Getter
@Setter
public class ExchangeRate extends AbstractEntity{
    private Double value;

    private Date date;

    @ManyToOne
    private Currency referenceCurrency;

    @OneToOne
    private Currency currency;
}
