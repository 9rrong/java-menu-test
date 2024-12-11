package menu.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String STRINGS_REGEX = "([가-힣]+)(,[가-힣]+)*";
    private static final Pattern STRINGS_PATTERN = Pattern.compile(STRINGS_REGEX);
    private static final String STRINGS_DELIMITER = ",";

    public static List<String> convertInput(String input) {
        validateInput(input);
        List<String> inputs = parseInput(input);
        validateDuplicatedInputs(inputs);

        return inputs;
    }

    private static List<String> parseInput(String input) {
        return List.of(input.split(STRINGS_DELIMITER));
    }

    private static void validateDuplicatedInputs(List<String> inputs) {
        Set<String> uniqueInputs = new HashSet<>();

        for (String input : inputs) {
            if (!uniqueInputs.add(input)) {
                throw new IllegalArgumentException(ErrorCode.INPUT_DUPLICATED.getMessage());
            }
        }
    }

    private static void validateInput(String orderInput) {
        validateNullOrBlank(orderInput);
        validateInputSyntax(orderInput);
    }

    private static void validateInputSyntax(String orderInput) {
        Matcher matcher = STRINGS_PATTERN.matcher(orderInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorCode.INPUT_INVALID_SYNTAX.getMessage());
        }
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.INPUT_INVALID_SYNTAX.getMessage());
        }
    }
}
