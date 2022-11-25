package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @DisplayName("볼, 스트라이크 갯수를 세는 기능")
    @ParameterizedTest(name = "balls : {0}, 결과 : {1}")
    @MethodSource("createBallsCompareSource")
    void create3StrikeTest(Balls userBalls, GameResult expected) {
        Balls computerBalls = Balls.of(List.of(1, 2, 3));

        GameResult gameResult = computerBalls.compare(userBalls);

        assertThat(gameResult)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }


    public static Stream<Arguments> createBallsCompareSource() {
        return Stream.of(
                Arguments.arguments(Balls.of(List.of(1, 2, 3)), GameResult.of(3, 0)),
                Arguments.arguments(Balls.of(List.of(2, 1, 3)), GameResult.of(1, 2)),
                Arguments.arguments(Balls.of(List.of(3, 1, 2)), GameResult.of(0, 3)),
                Arguments.arguments(Balls.of(List.of(4, 5, 6)), GameResult.of(0, 0))
        );
    }
}
