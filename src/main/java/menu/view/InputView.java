package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.InputParser;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class InputView {
    private static final String COACH_NAMES_PROMPT = System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INEDIBLE_MENUS_PROMPT_FORMAT = System.lineSeparator() + "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> readCoachNames() {
        System.out.println(COACH_NAMES_PROMPT);
        String input = Console.readLine();

        return InputParser.convertInput(input);
    }

    public List<String> readInedibleMenus(String coachName) {
        System.out.println(String.format(INEDIBLE_MENUS_PROMPT_FORMAT, coachName));
        String input = Console.readLine();

        if (Objects.equals(input, "")) {
            return Collections.emptyList();
        }

        return InputParser.convertInput(input);
    }

}