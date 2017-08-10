package com.kassandra.repository.domain;

import com.kassandra.exception.CurrencyValidationException;
import com.kassandra.util.StringsUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Currency entity class
 *
 * @author Onur Karaduman
 * @since 08.06.17
 */
@Entity
@Getter
@Setter
public class Currency extends AbstractEntity {

    @Column(unique = true)
    private String name;

    private String imagePath;

    /**
     * check exchangerate is valid or not
     *
     * @return
     */
    @Transient
    public boolean isValid() throws CurrencyValidationException {
        String message = "";
        if (!StringsUtil.isValid(this.name)) {
            message += "Name is not valid.";
        }
        if (StringsUtil.isValid(message)) {
            throw new CurrencyValidationException(message, null);
        }
        return true;
    }
}
