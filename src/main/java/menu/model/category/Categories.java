package menu.model.category;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.DayOfWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Categories {

    private static final int CATEGORY_MIN_INDEX = 1;
    private static final int CATEGORY_MAX_INDEX = 5;

    private final List<Category> categories;

    private Categories(List<Category> categories) {
        this.categories = categories;
    }

    public static Categories ofRandomValues() {
        List<Category> categoryList = new ArrayList<>();

        while (true) {
            Category randomCategory = getRandomCategory();

            if (checkDuplicatesExceeded(categoryList, randomCategory)) {
                categoryList.add(randomCategory);
            }

            if (categoryList.size() == DayOfWeek.SIZE) {
                return new Categories(categoryList);
            }
        }
    }

    public List<Category> getCategories() {
        return categories;
    }

    private static boolean checkDuplicatesExceeded(List<Category> categoryList, Category randomCategory) {
        long numberOfCategory = categoryList.stream()
                .filter(category -> category.equals(randomCategory))
                .count();

        return numberOfCategory < 2;
    }

    private static Category getRandomCategory() {
        int randomInt = Randoms.pickNumberInRange(CATEGORY_MIN_INDEX, CATEGORY_MAX_INDEX);
        return Arrays.stream(Category.values())
                .filter(category ->
                        category.isOrderNumber(randomInt)
                )
                .findFirst()
                .orElseThrow();
    }
}
