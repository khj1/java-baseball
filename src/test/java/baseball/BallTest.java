package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void createStrikeTest() {
        Ball userBall = Ball.of(1, 1);
        Ball computerBall = Ball.of(1, 1);

        assertThat(userBall.compare(computerBall)).isEqualTo(Result.STRIKE);
    }

}
