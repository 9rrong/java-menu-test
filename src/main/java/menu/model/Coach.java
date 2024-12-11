package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> inedibleMenus;

    public Coach(String name, List<String> inedibleMenus) {
        this.name = name;
        this.inedibleMenus = inedibleMenus;
    }

    public static Coach ofValue(String name) {
        validateNameLength(name);

        return new Coach(name, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private static void validateNameLength(String name) {
        if (!(name.length() >= 2) || !(name.length() <= 4)) {
            throw new IllegalArgumentException(ErrorCode.COACH_NAME_LENGTH_OUT_OF_RANGE.getMessage());
        }
    }

    public void addInedibleMenus(List<String> inedibleMenuInputs) {
        validateMenuInputs(inedibleMenuInputs);
        inedibleMenus.addAll(inedibleMenuInputs);
    }

    public boolean isName(String value) {
        return name.equals(value);
    }

    private void validateMenuInputs(List<String> inedibleMenuInputs) {
        for (String input : inedibleMenuInputs) {
            if (!MenuCategories.isMenuExisting(input)) {
                throw new IllegalArgumentException(ErrorCode.MENU_NOT_FOUND.getMessage());
            }
        }
    }
}
