package menu.model.coach;

import menu.model.MenuSelectionStrategy;

import java.util.LinkedList;
import java.util.List;

public class FixedMenuSelectionStrategy implements MenuSelectionStrategy {
    private final LinkedList<Integer> menuIndexes;

    public FixedMenuSelectionStrategy(List<Integer> menuIndexes) {
        this.menuIndexes = new LinkedList<>(menuIndexes);
    }

    @Override
    public String select(List<String> menuList) {
        return menuList.get(menuIndexes.pop());
    }
}
