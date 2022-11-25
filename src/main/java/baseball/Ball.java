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
        return Result.STRIKE;
    }
}
