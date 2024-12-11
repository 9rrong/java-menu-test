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

    private static void validateNameLength(String name) {
        if (!(name.length() >= 2) || !(name.length() <= 4)) {
            throw new IllegalArgumentException(ErrorCode.COACH_NAME_LENGTH_OUT_OF_RANGE.getMessage());
        }
    }
}
