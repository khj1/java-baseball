package baseball.view;

import baseball.Command;
import baseball.constant.ErrorMessage;
import baseball.constant.GuidanceMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String SPLIT_REGEX = "";

    public List<Integer> readNumbers() {
        System.out.print(GuidanceMessage.REQUEST_BALL_NUMBERS);

        String numbers = Console.readLine();
        validateNumeric(numbers);

        return convertToList(numbers);
    }

    private List<Integer> convertToList(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumeric(String input) {
        if (isNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_INPUT);
        }
    }

    private boolean isNonNumeric(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public Command readCommand() {
        System.out.println(GuidanceMessage.INFORM_GAME_COMPLETE);
        System.out.println(GuidanceMessage.REQUEST_GAME_COMMAND);

        String command = Console.readLine();
        validateNumeric(command);

        return Command.of(Integer.parseInt(command));
    }
}
