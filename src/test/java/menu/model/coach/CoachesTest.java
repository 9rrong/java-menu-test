package menu.model.coach;

import menu.model.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachesTest {

    @ParameterizedTest
    @CsvSource({
            "일일,이이,삼삼,사사,오오,육육",
            "일일"
    })
    void 잘못된_코치_수_예외테스트(String input) {
        List<String> inputList = List.of(input.split(","));
        assertThatThrownBy(() -> Coaches.ofValue(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.COACHES_NUMBER_OUT_OF_RANGE.getMessage());
    }



}