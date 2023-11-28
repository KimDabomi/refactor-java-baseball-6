package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import baseball.domain.Game;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {
    private static Stream<Arguments> provideUserNumberData() {
        return Stream.of(
            Arguments.of("a12"),
            Arguments.of("1234"),
            Arguments.of("012"),
            Arguments.of("122")
        );
    }

    @ParameterizedTest(name = "{index} - 입력값: {0}")
    @MethodSource("provideUserNumberData")
    @DisplayName("사용자 입력값 예외 확인")
    void testOrderExceptions(String userNumber) {
        assertSimpleTest(() ->
                Assertions.assertThatThrownBy(() -> Game.processNumber(userNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
