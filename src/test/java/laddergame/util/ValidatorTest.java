package laddergame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    "})
    @DisplayName("isNonBlank(): stringInput이 NULL 또는 빈문자열인 경우 false를 그렇지 않은 경우 true를 반환한다.")
    void testIsNonBlank(String stringInput) {
        assertThat(Validator.isNonBlank(stringInput)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"NULL:1:false", "'':1:false", "'  ':1:false", "abc:1:false", "abc:3:true", "abc:4:true"}, delimiter = ':', nullValues = "NULL")
    @DisplayName("isValidStringLength(): stringInput이 NULL 또는 빈문자열 또는 stringInput의 길이가 maxStringLength 보다 큰 경우 false를 그렇지 않은 경우 true를 반환한다.")
    void testIsValidStringLength(String stringInput, int maxStringLength, boolean expected) {
        assertThat(Validator.isValidStringLength(stringInput, maxStringLength)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"abc:false", "1.1:false", "NULL:false", "'':false", "'   ':false", "-1:false", "0:false", "0123:false", "1:true", "10:true", "14000:true"}, delimiter = ':', nullValues = "NULL")
    @DisplayName("isPositiveInteger(): numberString이 양의 정수인 경우 true를 그렇지 않은 경우 false를 반환한다.")
    void testIsPositiveInteger(String numberString, boolean expected) {
        assertThat(Validator.isPositiveInteger(numberString)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:false", "5:2:true"}, delimiter = ':')
    @DisplayName("isGreaterThanStandard(): number가 standard 보다 큰 경우 true를 그렇자 않은 경우 false를 반환한다.")
    void testIsGreaterThanStandard(int number, int standard, boolean expected) {
        assertThat(Validator.isGreaterThanStandard(number, standard)).isEqualTo(expected);
    }
}
