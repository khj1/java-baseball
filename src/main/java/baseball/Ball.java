package baseball;

public class Ball {

    private final BallNumber number;
    private final Position position;

    public Ball(int number, int position) {
        this.number = BallNumber.of(number);
        this.position = Position.of(position);
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public Result compare(Ball ball) {
        if (isStrike(ball)) {
            return Result.STRIKE;
        }
        if (isBall(ball)) {
            return Result.BALL;
        }
        return Result.NOTHING;
    }

    private boolean isStrike(Ball ball) {
        return ball.isSamePosition(position) && ball.isSameNumber(number);
    }

    private boolean isBall(Ball ball) {
        return ball.isSameNumber(number);
    }

    private boolean isSameNumber(BallNumber number) {
        return this.number.equals(number);
    }

    private boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
