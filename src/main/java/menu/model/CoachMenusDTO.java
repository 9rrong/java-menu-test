package menu.model;

import java.util.List;

public class CoachMenusDTO {
    public final String coachName;
    public final List<String> menus;

    public CoachMenusDTO(String coachName, List<String> menus) {
        this.coachName = coachName;
        this.menus = menus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenus() {
        return menus;
    }
}
