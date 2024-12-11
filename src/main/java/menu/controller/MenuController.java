package menu.controller;

import menu.model.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRecommendation() {
        outputView.printStartMessage();
        Coaches coaches = retrySupplierUntilValid(() -> Coaches.ofValue(inputView.readCoachNames()));

        coaches.getCoachNames()
                .forEach(coachName ->
                        retryUntilValid(() -> addInedibleMenusByCoachName(coachName, coaches))
                );

    }

    private void addInedibleMenusByCoachName(String coachName, Coaches coaches) {
        List<String> inedibleMenus = inputView.readInedibleMenus(coachName);
        coaches.addInedibleMenuByName(coachName, inedibleMenus);
    }

    private void retryUntilValid(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException | IllegalStateException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private <T> T retrySupplierUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
