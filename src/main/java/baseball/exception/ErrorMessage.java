package baseball.exception;

public enum ErrorMessage {
    ERROR_MESSAGE_HEADER("[ERROR] "),
    TYPE_ERROR_MESSAGE("숫자만 입력 가능합니다."),
    SIZE_ERROR_MESSAGE("3자리 수만 입력 가능합니다."),
    RANGE_ERROR_MESSAGE("1부터 9까지의 수만 입력 가능합니다."),
    DUPLICATE_ERROR_MESSAGE("중복된 수는 입력 불가합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_HEADER.errorMessage + errorMessage;
    }
}
