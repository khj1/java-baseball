package baseball;

public enum Result {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String unit;

    Result(String unit) {
        this.unit = unit;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    @Override
    public String toString() {
        return unit;
    }
}
