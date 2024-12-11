package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_ANNOUNCE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_ANNOUNCE = System.lineSeparator() + "메뉴 추천 결과입니다.";
    private static final String END_ANNOUNCE = System.lineSeparator() + "추천을 완료했습니다.";


    public void printStartMessage() {
        System.out.println(START_ANNOUNCE);
    }

    public void printResult(List<String> results) {
        System.out.println(RESULT_ANNOUNCE);

        results.forEach(System.out::println);
    }

    public void printEndMessage() {
        System.out.println(END_ANNOUNCE);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}