package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    Variables variables = new Variables();
    public List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < variables.MAX_NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private boolean isNotListSize(List<Integer> list, int size) {
        return list.size() != size;
    }

    public List<Integer> getUserInput() {
        System.out.print(variables.INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            int numberValue = Character.getNumericValue(ch);
            numberExceptions(numbers, numberValue);
            numbers.add(numberValue);
        }

        if (isNotListSize(numbers, variables.MAX_NUM_LENGTH)) {
            throw new IllegalArgumentException(variables.INPUT_NOT_LIST_SIZE_MESSAGE);
        }

        return numbers;
    }

    private boolean isContainNumber(List<Integer> list, int value) {
        return list.contains(value);
    }

    private boolean isNumberRange(int value, int min, int max) {
        return value < min && value > max;
    }

    private void numberExceptions(List<Integer> numbers, int numberValue) {
        if (isContainNumber(numbers, numberValue)) {
            throw new IllegalArgumentException(variables.INPUT_DUPLICATED_NUMBER_MESSAGE);
        }

        if (isNumberRange(numberValue, variables.MIN_NUM_RANGE, variables.MAX_NUM_RANGE)) {
            throw new IllegalArgumentException(variables.INPUT_NOT_NUMBER_RANGE_MESSAGE);
        }
    }
}
