package com.kassandra.util;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * @author Onur Karaduman
 * @since 08.06.17
 */
public class StringsUtil {
    /**
     * validation of String
     *
     * @param element any string
     * @return result of element is not null and not empty
     */
    public static boolean isValid(String element) {
        return element != null && !element.isEmpty() ? true : false;
    }

    /**
     * email validation
     * pattern= ^\\s*?(.+)@(.+?)\\s*$
     *
     * @param email
     * @return
     * @see @{@link EmailValidator}
     */
    public static boolean isValidEmail(String email) {
        if (isValid(email)) {
            return EmailValidator.getInstance().isValid(email);
        }
        return false;
    }
}
