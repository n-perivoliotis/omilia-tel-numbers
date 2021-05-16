package org.perivoliotis.omilia.tel.numbers;

import org.apache.commons.lang3.StringUtils;

public class TelephoneNumberValidator {

    public boolean validateNumber(String phoneNumber) {

        if (!StringUtils.isEmpty(phoneNumber)) {
            if (phoneNumber.length() == 10) {
                return phoneNumber.startsWith("2") || phoneNumber.startsWith("69");
            } else if (phoneNumber.length() == 14) {
                return phoneNumber.startsWith("00302") || phoneNumber.startsWith("003069");
            }
        }

        return false;
    }
}
