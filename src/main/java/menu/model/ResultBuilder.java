package menu.model;

import menu.model.coach.Coaches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultBuilder {
    private final List<String> result = new ArrayList<>();

    public List<String> buildResult(Categories categories, Coaches coaches) {
        addDayOfWeek();
        addCategories(categories);
        addCoachMenus(coaches);

        return result;
    }

    private void addCoachMenus(Coaches coaches) {
        result.addAll(coaches.toCoachMenusDTOs()
                .stream()
                .map(coachMenusDTO -> formatString(coachMenusDTO.getCoachName(), coachMenusDTO.getMenus())
                ).collect(Collectors.toUnmodifiableList()));
    }

    private void addCategories(Categories categories) {
        result.add(formatString("카테고리", categories.getCategories().stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toUnmodifiableList())));
    }

    private void addDayOfWeek() {
        result.add(formatString("구분", Arrays.stream(DayOfWeek.values())
                .map(DayOfWeek::getDayName)
                .collect(Collectors.toUnmodifiableList())));
    }

    private String formatString(String header, List<String> strings) {
        return "[ " + header + " | " + String.join(" | ", strings) + " ]";
    }
}
