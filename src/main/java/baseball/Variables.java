package baseball;

public class Variables {
    public boolean RUN_GAME_STATUS = true;
    public final int MAX_NUM_LENGTH = 3;
    public final int MIN_NUM_RANGE = 1;
    public final int MAX_NUM_RANGE = 9;

    public final String SELECT_RESTART_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final String BALL_STATUS = "볼 ";
    public final String STRIKE_STATUS = "스트라이크 ";
    public final String NOTHING_STATUS = "낫싱";
    public final String THREE_STRIKE_MESSAGE = "3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public final String INPUT_DUPLICATED_NUMBER_MESSAGE = "중복된 값은 입력불가합니다.";
    public final String INPUT_NOT_NUMBER_RANGE_MESSAGE = "1~9 사이의 정수만 입력가능합니다.";
    public final String INPUT_NOT_LIST_SIZE_MESSAGE = "세자리 수만 입력가능합니다.";
}
