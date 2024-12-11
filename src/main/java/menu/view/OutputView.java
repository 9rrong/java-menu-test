package menu.view;

public class OutputView {

    private static final String START_ANNOUNCE = "점심 메뉴 추천을 시작합니다.";

    public void printStartMessage() {
        System.out.println(START_ANNOUNCE);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}