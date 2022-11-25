package baseball.controller;

import baseball.Balls;
import baseball.GameResult;
import baseball.view.InputView;
import baseball.view.OutputVIew;

import java.util.List;

public class BaseballController {

    public static final boolean IN_PROGRESS = true;
    public static final boolean COMPLETE = false;
    
    private final InputView inputView;
    private final OutputVIew outputVIew;

    public BaseballController() {
        inputView = new InputView();
        outputVIew = new OutputVIew();
    }

    public void run() {
        outputVIew.printGameIntro();
        Balls computer = Balls.createRandom();

        boolean gameStatus = IN_PROGRESS;
        while (gameStatus) {
            List<Integer> numbers = inputView.readNumbers();
            Balls user = Balls.of(numbers);

            GameResult result = computer.compare(user);
            gameStatus = updateStatus(result);
        }
    }

    private boolean updateStatus(GameResult result) {
        if (result.isComplete()) {
            return COMPLETE;
        }
        return IN_PROGRESS;
    }

}
