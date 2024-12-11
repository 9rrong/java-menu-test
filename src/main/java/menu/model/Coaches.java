package menu.model;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validateNumberOfCoaches(coaches);
        this.coaches = coaches;
    }

    public static Coaches ofValue(List<String> coachNames) {
        return new Coaches(
                coachNames.stream()
                        .map(Coach::ofValue)
                        .collect(Collectors.toUnmodifiableList())
        );
    }

    private void validateNumberOfCoaches(List<Coach> coaches) {
        if (!(coaches.size() >= 2) || !(coaches.size() <= 5)) {
            throw new IllegalArgumentException(ErrorCode.COACHES_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

}
