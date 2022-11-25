package baseball.controller;

import baseball.Balls;
import baseball.Command;
import baseball.GameResult;
import baseball.view.InputView;
import baseball.view.OutputVIew;

import java.util.List;

public class BaseballController {

    public static final boolean IN_PROGRESS = true;
    public static final boolean COMPLETE = false;

    private final InputView inputView;
    private final OutputVIew outputVIew;
    private Balls computer;

    public BaseballController() {
        inputView = new InputView();
        outputVIew = new OutputVIew();
        computer = Balls.createRandom();
    }

    public void run() {
        outputVIew.printGameIntro();

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
            return askRestart();
        }
        return IN_PROGRESS;
    }

    private boolean askRestart() {
        Command command = inputView.readCommand();
        if (command.isRestart()) {
            computer = Balls.createRandom();
            return IN_PROGRESS;
        }
        return COMPLETE;
    }

}
