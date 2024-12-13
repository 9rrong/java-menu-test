package menu.model;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String STRINGS_DELIMITER = ",";
    private static final String STRINGS_REGEX = "[가-힣a-zA-Z]+(?:" + STRINGS_DELIMITER + "[가-힣a-zA-Z]+)*";
    private static final Pattern STRINGS_PATTERN = Pattern.compile(STRINGS_REGEX);

    public static List<String> convertInput(String input) {
        validateInput(input);
        List<String> inputs = parseInput(input);
        ensureNoDuplicates(inputs);

        return inputs;
    }

    private static List<String> parseInput(String input) {
        return List.of(input.split(STRINGS_DELIMITER));
    }

    private static void ensureNoDuplicates(List<String> inputs) {
        if (inputs.size() != new HashSet<>(inputs).size()) {
            throw new IllegalArgumentException(ErrorCode.INPUT_DUPLICATED.getMessage());
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
