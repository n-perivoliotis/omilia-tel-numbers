package org.perivoliotis.omilia.tel.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelephoneNumberValidatorTest {

    TelephoneNumberValidator telephoneNumberValidator = new TelephoneNumberValidator();

    @Test
    void shouldMarkValidWhenLength10AndStartWith2or69() {
        Assertions.assertTrue(telephoneNumberValidator.validateNumber("2109945654"));
        Assertions.assertTrue(telephoneNumberValidator.validateNumber("6985567676"));
    }

    @Test
    void shouldMarkValidWhenLength14AndStartWith00302or003069() {
        Assertions.assertTrue(telephoneNumberValidator.validateNumber("00302109945654"));
        Assertions.assertTrue(telephoneNumberValidator.validateNumber("00306985567676"));
    }

    @Test
    void shouldMarkInvalidWhenLengthNullOrEmpty() {
        Assertions.assertFalse(telephoneNumberValidator.validateNumber(null));
        Assertions.assertFalse(telephoneNumberValidator.validateNumber(""));
    }

    @Test
    void shouldMarkInvalidWhenLength10AndNotStartWith2or69() {
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("9945654210"));
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("5567676698"));
    }

    @Test
    void shouldMarkInvalidWhenLength14AndNotStartWith00302or003069() {
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("21099456540030"));
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("69855600307676"));
    }

    @Test
    void shouldMarkInvalidWhenLengthNot10or14() {
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("345"));
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("12345678901"));
        Assertions.assertFalse(telephoneNumberValidator.validateNumber("123456789012345"));
    }
}
