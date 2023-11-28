package baseball.domain;

import baseball.exception.UserNumberException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String splitUnit = "";

    public static List<Integer> process(String userNumber, List<Integer> randomNumbers) {
        List<Integer> numbers = processNumber(userNumber);
        List<Integer> gameResult = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        CalculateResult result = getCalculateResult(randomNumbers, numbers, ball, strike);

        gameResult.add(result.ball());
        gameResult.add(result.strike());
        return gameResult;
    }

    public static List<Integer> processRandom() {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.getRandomNumber();
    }

    public static List<Integer> processNumber(String userNumber) {
        UserNumberException.checkNumber(userNumber);
        String[] numbers = userNumber.split(splitUnit);
        List<Integer> numbersList = new ArrayList<>();
        for (String number : numbers) {
            numbersList.add(Integer.valueOf(number));
        }
        return numbersList;
    }

    private static CalculateResult getCalculateResult(List<Integer> randomNumbers, List<Integer> numbers, int ball, int strike) {
        for (int i = 0; i <numbers.size(); i++) {
            if (randomNumbers.contains(numbers.get(i)) && randomNumbers.indexOf(numbers.get(i)) != i) {
                ball++;
            }
            if (randomNumbers.indexOf(numbers.get(i)) == i) {
                strike++;
            }
        }
        return new CalculateResult(ball, strike);
    }

    private record CalculateResult(int ball, int strike) {}
}
