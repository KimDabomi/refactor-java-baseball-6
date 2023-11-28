package baseball.view;

public enum ViewMessage {
    READ_START_MESSAGE("숫자를 입력해주세요 : "),
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    NOTHING_MESSAGE("낫싱"),
    BALL_MESSAGE("%d볼"),
    STRIKE_MESSAGE("%d스트라이크"),
    BALL_AND_STRIKE_MESSAGE("%d볼 %d스트라이크"),
    GAME_DONE_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    SELECT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String viewMessage;

    ViewMessage(String viewMessage) {
        this.viewMessage = viewMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }
}
