package io.github.anthogdn.iataaa.checkersApi.exception;

public enum CodeException {
    BAD_TOKEN("Request not authorized because player has bad token"),
    CHECKERS_IS_OVER("Checkers id over"),
    IS_NOT_TURN_PLAYER("It's not turn player"),
    MOVE_IS_NOT_VALIDATE("Move is not validate");

    private String message;

    CodeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
