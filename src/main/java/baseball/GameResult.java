package baseball;

public class GameResult {
    public static final int NO_STRIKE = 0;
    public static final int NO_BALL = 0;

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }


    public static GameResult init() {
        return new GameResult(NO_STRIKE, NO_BALL);
    }

    public static GameResult of(int strike, int ball) {
        return new GameResult(strike, ball);
    }

    public void update(Result result) {
        if (result.isStrike()) {
            strike++;
        }
        if (result.isBall()) {
            ball++;
        }
    }
}
