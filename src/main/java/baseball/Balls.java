package baseball;

import baseball.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

    public static final int STARTING_POSITION = 1;
    public static final int VALID_NUMBER_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        validate(balls);
        this.balls = convertToBalls(balls);
    }

    private void validate(List<Integer> balls) {
        validateUnique(balls);
    }

    private void validateUnique(List<Integer> balls) {
        if (hasDuplicatedNumbers(balls)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_INPUT);
        }
    }

    private boolean hasDuplicatedNumbers(List<Integer> balls) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(balls);

        return uniqueNumbers.size() != VALID_NUMBER_COUNT;
    }

    private List<Ball> convertToBalls(List<Integer> numbers) {
        int position = STARTING_POSITION;
        List<Ball> balls = new ArrayList<>();

        for (Integer number : numbers) {
            Ball ball = Ball.of(number, position++);
            balls.add(ball);
        }
        return balls;
    }

    public static Balls createRandom() {
        return new Balls(createRandomNumbers());
    }

    private static List<Integer> createRandomNumbers() {
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < VALID_NUMBER_COUNT) {
            numbers.add(Randoms.pickNumberInRange(BallNumber.MIN_RANGE, BallNumber.MAX_RANGE));
        }
        return new ArrayList<>(numbers);
    }

    public static Balls of(List<Integer> balls) {
        return new Balls(balls);
    }

    public GameResult compare(Balls otherBalls) {
        GameResult gameResult = GameResult.init();

        for (Ball ball : balls) {
            Result compareResult = otherBalls.compareEach(ball);
            gameResult.update(compareResult);
        }
        return gameResult;
    }

    private Result compareEach(Ball ball) {
        return balls.stream()
                .map(otherBall -> otherBall.compare(ball))
                .filter(result -> result.isStrike() || result.isBall())
                .findFirst()
                .orElse(Result.NOTHING);
    }
}
