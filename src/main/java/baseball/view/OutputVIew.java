package baseball.view;

import baseball.GameResult;
import baseball.constant.GuidanceMessage;

public class OutputVIew {

    public void printResult(GameResult result) {
        System.out.println(result);
    }

    public void printGameIntro() {
        System.out.println(GuidanceMessage.GAME_INTRO);
    }
}
