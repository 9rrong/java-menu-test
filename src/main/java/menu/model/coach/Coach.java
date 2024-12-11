package menu.model.coach;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.CoachMenusDTO;
import menu.model.DayOfWeek;
import menu.model.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private final String name;

    private final List<String> menus;
    private final List<String> inedibleMenus;

    public Coach(String name, List<String> inedibleMenus) {
        this.name = name;
        this.menus = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void addInedibleMenus(List<String> inedibleMenuInputs) {
        validateMenuInputs(inedibleMenuInputs);
        inedibleMenus.addAll(inedibleMenuInputs);
    }

    public boolean isName(String value) {
        return name.equals(value);
    }

    public void addRandomMenu(Category category) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus()).get(0);

            if (checkMenu(menu)) {
                menus.add(menu);
                break;
            }
        }
    }

    public CoachMenusDTO coachMenusDTO() {
        return new CoachMenusDTO(name, menus);
    }

    private boolean checkMenu(String menu) {
        return !(isDuplicated(menu) && isInedible(menu));
    }

    private boolean isInedible(String menu) {
        return inedibleMenus.stream()
                .anyMatch(m -> Objects.equals(m, menu));
    }

    private boolean isDuplicated(String menu) {
        long numberOfMenu = menus.stream()
                .filter(m -> Objects.equals(m, menu))
                .count();
        return numberOfMenu < 1;
    }

    private void validateMenuInputs(List<String> inedibleMenuInputs) {
        for (String input : inedibleMenuInputs) {
            if (!Category.isMenuExisting(input)) {
                throw new IllegalArgumentException(ErrorCode.MENU_NOT_FOUND.getMessage());
            }
        }
    }
}
