package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    Variables variables = new Variables();
    Numbers numbers = new Numbers();

    private void getCountMessage(StringBuilder result, int ballCount, int strikeCount) {
        if (ballCount > 0) {
            result.append(ballCount).append(variables.BALL_STATUS);
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append(variables.STRIKE_STATUS);
        }

        if (ballCount == 0 && strikeCount == 0) {
            result.append(variables.NOTHING_STATUS);
        }
    }

    private boolean selectExit() {
        System.out.println(variables.SELECT_RESTART_EXIT);
        int choice = Integer.parseInt(Console.readLine());
        boolean selectNum = true;
        if (choice != 1) {
            selectNum = false;
        }
        return selectNum;
    }

    private void checkCountResult(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();

        if (strikeCount == variables.MAX_NUM_LENGTH) {
            result.append(variables.THREE_STRIKE_MESSAGE);
            System.out.println(result);
            boolean userSelectNum = selectExit();
            if (userSelectNum) {
                playGame();
            }
            if (!userSelectNum) {
                variables.RUN_GAME_STATUS = false;
            }
            return;
        }

        getCountMessage(result, ballCount, strikeCount);
        System.out.println(result.toString().trim());
    }

    private void getGameResult(List<Integer> computer) {
        List<Integer> user = numbers.getUserInput();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < variables.MAX_NUM_LENGTH; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                ballCount++;
            }
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }

        checkCountResult(ballCount, strikeCount);
    }
    private void getGameProcess(List<Integer> computer) {
        while (variables.RUN_GAME_STATUS) {
            getGameResult(computer);
        }
    }

    public void playGame() {
        List<Integer> computerNum = numbers.getRandomNumber();
        getGameProcess(computerNum);
    }
}
