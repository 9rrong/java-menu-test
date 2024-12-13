package menu.model.coach;

import menu.model.ErrorCode;
import menu.model.MenuSelectionStrategy;
import menu.model.category.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private final String name;

    private final List<String> menus;
    private final List<String> inedibleMenus;

    private Coach(String name, List<String> inedibleMenus) {
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

    public void addSelectedMenu(List<String> menus, MenuSelectionStrategy menuSelectionStrategy) {
        while (true) {
            String selectedMenu = menuSelectionStrategy.select(menus);

            if (isMenuValid(selectedMenu)) {
                this.menus.add(selectedMenu);
                break;
            }
        }
    }

    public CoachMenusDTO toCoachMenusDTO() {
        return new CoachMenusDTO(name, menus);
    }

    private boolean isMenuValid(String menu) {
        return isUnique(menu) && isEdible(menu);
    }

    private boolean isEdible(String menu) {
        return inedibleMenus.stream()
                .noneMatch(restricted -> Objects.equals(restricted, menu));
    }

    private boolean isUnique(String menu) {
        return menus.stream()
                .noneMatch(selected -> Objects.equals(selected, menu));
    }

    private void validateMenuInputs(List<String> inedibleMenuInputs) {
        for (String input : inedibleMenuInputs) {
            if (!Category.isMenuExisting(input)) {
                throw new IllegalArgumentException(ErrorCode.MENU_NOT_FOUND.getMessage());
            }
        }
    }
}
