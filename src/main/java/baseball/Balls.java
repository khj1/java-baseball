package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

    public static final int STARTING_POSITION = 1;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int MAX_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = convertToBalls(balls);
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

        while (numbers.size() < MAX_SIZE) {
            numbers.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
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
