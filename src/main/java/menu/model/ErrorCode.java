package menu.model;

public enum ErrorCode {
    COACHES_OUT_OF_RANGE("코치는 최소 2명 이상 5명 이하로 입력해야 합니다."),
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

