package baseball;

import baseball.constant.ErrorMessage;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;

    private final int number;

    public BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_EXCEPTION);
        }
    }

    private static boolean isInvalidRange(int number) {
        return number > MAX_RANGE || number < MIN_RANGE;
    }

    public static BallNumber of(int number) {
        return new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
