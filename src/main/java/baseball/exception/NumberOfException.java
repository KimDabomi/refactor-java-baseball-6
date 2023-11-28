package baseball.exception;

public enum NumberOfException {
    USER_NUMBER_SIZE(3),
    USER_NUMBER_MIN(1),
    USER_NUMBER_MAX(9);

    private final int value;

    NumberOfException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
