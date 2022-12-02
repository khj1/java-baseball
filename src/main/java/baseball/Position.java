package baseball;

import baseball.constant.ErrorMessage;

import java.util.Objects;

public class Position {

    public static final int MAX_POSITION = 3;

    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private static void validate(int position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_INPUT);
        }
    }

    private static boolean isInvalidPosition(int position) {
        return position > MAX_POSITION;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
