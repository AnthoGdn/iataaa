package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.exception.CodeException;
import io.github.anthogdn.iataaa.checkersDomain.model.ValidityErrorsCheckersMove;

public class CodeExceptionMapper {
    public static CodeException validityErrorsCheckersMoveToCodeException(ValidityErrorsCheckersMove validityErrorsCheckersMove) {
        switch (validityErrorsCheckersMove) {
            case CHECKERS_IS_OVER: return CodeException.CHECKERS_IS_OVER;
            case IS_NOT_TURN_PLAYER: return CodeException.IS_NOT_TURN_PLAYER;
            case MOVE_IS_NOT_VALIDATE: return CodeException.MOVE_IS_NOT_VALIDATE;
        }
        throw new IllegalArgumentException();
    }
}
