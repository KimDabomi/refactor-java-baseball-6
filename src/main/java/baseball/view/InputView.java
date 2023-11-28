package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void readStart() {
        System.out.print(ViewMessage.READ_START_MESSAGE.getViewMessage());
    }

    public static String readUserNumber() {
        return Console.readLine();
    }
}
