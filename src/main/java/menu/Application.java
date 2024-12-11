package menu;

import menu.controller.MenuController;
import menu.model.ResultBuilder;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        MenuController menuController = initializeComponents();
        menuController.startRecommendation();
    }

    private MenuController initializeComponents() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ResultBuilder resultBuilder = new ResultBuilder();

        return new MenuController(inputView, outputView, resultBuilder);
    }
}
