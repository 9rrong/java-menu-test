package menu.model.coach;

import menu.model.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"일", "일이삼사오", ""})
    void 코치_이름_길이_예외테스트(String input) {
        assertThatThrownBy(() -> Coach.ofValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.COACH_NAME_LENGTH_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 중복된_메뉴는_저장하지_않는다() {
        Coach testCoach = Coach.ofValue("테스트");
        List<String> testMenus = List.of("일", "이", "삼", "사", "오");
        FixedMenuSelectionStrategy duplicatedMenuSelection = new FixedMenuSelectionStrategy(List.of(0, 0, 1, 2, 3));

        final int UNIQUE_MENU_COUNT = 4;

        for (int i = 0; i < UNIQUE_MENU_COUNT; i++) {
            testCoach.addSelectedMenu(testMenus, duplicatedMenuSelection);
        }

        assertThat(testCoach.toCoachMenusDTO().getMenus())
                .isEqualTo(List.of("일", "이", "삼", "사"));
    }
}