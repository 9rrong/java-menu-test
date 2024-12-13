package menu.model;

import menu.model.category.Categories;
import menu.model.category.Category;
import menu.model.coach.Coaches;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultBuilder {

    public List<String> buildMenuSummary(Categories categories, Coaches coaches) {
        return Stream.of(
                        formatDayOfWeek(),
                        formatCategories(categories),
                        formatCoachMenus(coaches)
                )
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> formatDayOfWeek() {
        return List.of(formatString(
                "구분",
                Arrays.stream(DayOfWeek.values())
                        .map(DayOfWeek::getDayName)
                        .collect(Collectors.toUnmodifiableList()))
        );
    }

    private List<String> formatCategories(Categories categories) {
        return List.of(formatString(
                "카테고리",
                categories.getCategories()
                        .stream()
                        .map(Category::getCategoryName)
                        .collect(Collectors.toUnmodifiableList())
        ));
    }

    private List<String> formatCoachMenus(Coaches coaches) {
        return coaches.toCoachMenusDTOs()
                .stream()
                .map(dto -> formatString(dto.getCoachName(), dto.getMenus()))
                .collect(Collectors.toUnmodifiableList());
    }

    private String formatString(String header, List<String> values) {
        return "[ " + header + " | " + String.join(" | ", values) + " ]";
    }
}
