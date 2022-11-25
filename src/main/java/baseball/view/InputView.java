package baseball.view;

import baseball.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String SPLIT_REGEX = "";

    public List<Integer> readNumbers() {
        String numbers = Console.readLine();
        validateNonBlank(numbers);
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

    private void validateNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
    }
}
