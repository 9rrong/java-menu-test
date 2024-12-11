package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.InputParser;

import java.util.List;

public class InputView {
    private static final String COACH_NAMES_PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> readCoachNames() {
        System.out.println(COACH_NAMES_PROMPT);
        String input = Console.readLine();

        return InputParser.convertInput(input);
    }

}