package baseball;

public class Ball {

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
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

    private boolean isSameNumber(int number) {
        return this.number == number;
    }

    private boolean isSamePosition(int position) {
        return this.position == position;
    }
}
