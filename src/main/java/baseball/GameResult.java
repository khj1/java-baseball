package baseball;

public class GameResult {
    public static final int NO_STRIKE = 0;
    public static final int NO_BALL = 0;
    public static final String BLANK = " ";

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

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        if (hasBall()) {
            message.append(ball).append(Result.BALL).append(BLANK);
        }
        if (hasStrike()) {
            message.append(strike).append(Result.STRIKE);
        }
        if (hasNothing()) {
            message.append(Result.NOTHING);
        }
        return message.toString().trim();
    }

    private boolean hasBall() {
        return ball > NO_BALL;
    }

    private boolean hasStrike() {
        return strike > NO_STRIKE;
    }

    private boolean hasNothing() {
        return strike == NO_STRIKE && ball == NO_BALL;
    }
}
