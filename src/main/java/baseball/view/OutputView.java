package baseball.view;

import java.util.List;

public class OutputView {
    private static final int NOTHING_NUMBER = 0;
    private static final int WIN_NUMBER = 3;

    public static void showStartMessage() {
        System.out.println(ViewMessage.START_MESSAGE.getViewMessage());
    }

    public static void showResultMessage(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);
        showNothing(ball, strike);
        showBall(ball, strike);
        showStrike(ball, strike);
        showBallAndStrike(ball, strike);
        showThreeStrike(strike);
    }

    private static void showNothing(int ball, int strike) {
        if (ball == NOTHING_NUMBER && strike == NOTHING_NUMBER) {
            System.out.println(ViewMessage.NOTHING_MESSAGE.getViewMessage());
        }
    }

    private static void showBall(int ball, int strike) {
        if (ball != NOTHING_NUMBER && strike == NOTHING_NUMBER) {
            System.out.printf(ViewMessage.BALL_MESSAGE.getViewMessage(), ball);
            System.out.println();
        }
    }

    private static void showStrike(int ball, int strike) {
        if (ball == NOTHING_NUMBER && strike != NOTHING_NUMBER) {
            System.out.printf(ViewMessage.STRIKE_MESSAGE.getViewMessage(), strike);
            System.out.println();
        }
    }

    private static void showBallAndStrike(int ball, int strike) {
        if (ball != NOTHING_NUMBER && strike != NOTHING_NUMBER) {
            System.out.printf(ViewMessage.BALL_AND_STRIKE_MESSAGE.getViewMessage(), ball, strike);
            System.out.println();
        }
    }

    private static void showThreeStrike(int strike) {
        if (strike == WIN_NUMBER) {
            System.out.println(ViewMessage.GAME_DONE_MESSAGE.getViewMessage());
            System.out.println(ViewMessage.SELECT_MESSAGE.getViewMessage());
        }
    }
}
