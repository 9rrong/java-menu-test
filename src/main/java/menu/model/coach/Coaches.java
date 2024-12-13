package menu.model.coach;

import menu.model.ErrorCode;
import menu.model.RandomMenuSelectionStrategy;
import menu.model.category.Category;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private static final int MENU_QUANTITY_MAX_SIZE = 2;

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validateNumberOfCoaches(coaches);
        this.coaches = coaches;
    }

    public static Coaches ofValue(List<String> coachNames) {
        return new Coaches(
                coachNames.stream()
                        .map(Coach::ofValue)
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CoachMenusDTO> toCoachMenusDTOs() {
        return coaches.stream()
                .map(Coach::toCoachMenusDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    public void addInedibleMenusByName(String name, List<String> menus) {
        validateNumberOfMenus(menus);

        coaches.stream()
                .filter(coach -> coach.isName(name))
                .forEach(coach -> coach.addInedibleMenus(menus));
    }

    public void addRandomMenusByCategory(Category category) {
        coaches.forEach(coach -> coach.addSelectedMenu(category.getMenus(), new RandomMenuSelectionStrategy()));
    }

    private void validateNumberOfMenus(List<String> menus) {
        if (menus.size() > MENU_QUANTITY_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorCode.MENU_QUANTITY_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateNumberOfCoaches(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(ErrorCode.COACHES_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

}
