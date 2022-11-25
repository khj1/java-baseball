package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    static Ball computerBall;

    @BeforeAll
    static void setUp() {
        computerBall = Ball.of(1, 1);
    }

    @Test
    void createStrikeTest() {
        Ball userBall = Ball.of(1, 1);

        assertThat(computerBall.compare(userBall)).isEqualTo(Result.STRIKE);
    }

    @Test
    void createBallTest() {
        Ball userBall = Ball.of(1, 2);

        assertThat(computerBall.compare(userBall)).isEqualTo(Result.BALL);
    }

    @Test
    void createNothingTest() {
        Ball userBall = Ball.of(2, 1);

        assertThat(computerBall.compare(userBall)).isEqualTo(Result.NOTHING);
    }

}
