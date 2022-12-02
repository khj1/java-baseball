package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    static Ball computerBall;

    @BeforeAll
    static void setUp() {
        computerBall = Ball.of(1, 1);
    }

    @DisplayName("공의 각 자리 숫자와 위치를 비교하는 기능")
    @ParameterizedTest(name = "숫자 : {0}, 위치: {1}, 결과: {2}")
    @MethodSource("createCompareSource")
    void createBallCompareTest(int number, int position, Result result) {
        Ball userBall = Ball.of(number, position);

        assertThat(computerBall.compare(userBall)).isEqualTo(result);
    }

    static Stream<Arguments> createCompareSource() {
        return Stream.of(
                Arguments.arguments(1, 1, Result.STRIKE),
                Arguments.arguments(1, 2, Result.BALL),
                Arguments.arguments(2, 1, Result.NOTHING)
        );
    }

}
