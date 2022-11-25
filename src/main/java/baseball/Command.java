package baseball;

import baseball.constant.ErrorMessage;

import java.util.Arrays;

public enum Command {
    RESTART(1),
    QUIT(2);

    private final int command;

    Command(int command) {
        this.command = command;
    }

    public static Command of(int input) {
        return Arrays.stream(values())
                .filter(command -> command.isSameCommand(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND_INPUT));
    }

    private boolean isSameCommand(int input) {
        return command == input;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
