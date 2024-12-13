package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuSelectionStrategy implements MenuSelectionStrategy {
    @Override
    public String select(List<String> menuList) {
        return Randoms.shuffle(menuList).get(0);
    }
}
