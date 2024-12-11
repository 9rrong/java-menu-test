package menu.model;

public enum ErrorCode {
    COACHES_OUT_OF_RANGE("코치는 2명 이상 5명 이하로 입력해야 합니다."),
    COACH_NAME_LENGTH_OUT_OF_RANGE("코치의 이름은 2글자 이상 4글자 이하로 입력해야 합니다."),
    INPUT_INVALID_SYNTAX("유효하지 않은 입력 형식입니다."),
    INPUT_DUPLICATED("입력은 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}

