package menu.model;

import java.util.List;

@FunctionalInterface
public interface MenuSelectionStrategy {
    String select(List<String> menuList);
}
