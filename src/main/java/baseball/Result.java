package baseball;

public enum Result {
    BALL, NOTHING, STRIKE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
