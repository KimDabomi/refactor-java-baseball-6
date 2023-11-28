package baseball.exception;

import java.util.Arrays;
import java.util.Optional;

public class UserNumberException extends IllegalArgumentException {
    private static final String numberType = "[+-]?\\d*(\\.\\d+)?";
    private static final String splitUnit = "";

    public UserNumberException(String errorMessage) {
    }

    public static void checkNumber(String userNumber) {
        checkTypeOfNumber(userNumber);
        checkSizeOfNumber(userNumber);
        checkRangeOfNumber(userNumber);
        checkDuplicateOfNumber(userNumber);
    }

    private static void checkTypeOfNumber(String userNumber) {
        Optional.ofNullable(userNumber)
                .filter(q -> q.matches(numberType))
                .orElseThrow(() -> new UserNumberException(ErrorMessage.TYPE_ERROR_MESSAGE.getErrorMessage()));
    }

    private static void checkSizeOfNumber(String userNumber) {
        if (userNumber.length() != NumberOfException.USER_NUMBER_SIZE.getValue()) {
            throw new UserNumberException(ErrorMessage.SIZE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static void checkRangeOfNumber(String userNumber) {
        String[] userNumbers = userNumber.split(splitUnit);
        Arrays.stream(userNumbers)
                .mapToInt(Integer::parseInt)
                .filter(UserNumberException::isValidRangeNumber)
                .findAny()
                .ifPresent(n -> {
                    throw new UserNumberException(ErrorMessage.RANGE_ERROR_MESSAGE.getErrorMessage());
                });
    }

    private static void checkDuplicateOfNumber(String userNumber) {
        String[] userNumbers = userNumber.split(splitUnit);
        boolean hasDuplicate = Arrays.stream(userNumbers)
                .distinct()
                .count() != userNumbers.length;
        if (hasDuplicate) {
            throw new UserNumberException(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static boolean isValidRangeNumber(int number) {
        return number < NumberOfException.USER_NUMBER_MIN.getValue() || number > NumberOfException.USER_NUMBER_MAX.getValue();
    }
}
