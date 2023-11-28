package baseball.controller;

import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final String RESTART = "1";
    private static final int WIN_NUMBER = 3;

    public BaseballController() {
    }

    public void run() {
        startGame();
        startSelect();
    }

    private void startGame() {
        OutputView.showStartMessage();
        startProcess();
    }

    private void startProcess() {
        List<Integer> result;
        List<Integer> randomNumbers = Game.processRandom();
        do {
            InputView.readStart();
            String userNumber = InputView.readUserNumber().trim();
            result = Game.process(userNumber, randomNumbers);
            OutputView.showResultMessage(result);
        } while (checkGameStatus(result));
    }

    private void startSelect() {
        String userNumber = InputView.readUserNumber().trim();
        if (userNumber.equals(RESTART)) {
            run();
        }
    }

    private boolean checkGameStatus(List<Integer> result) {
        int strike = result.get(1);
        return strike != WIN_NUMBER;
    }
}
