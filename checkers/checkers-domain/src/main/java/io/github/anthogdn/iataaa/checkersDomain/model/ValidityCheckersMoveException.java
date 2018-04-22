package io.github.anthogdn.iataaa.checkersDomain.model;

import java.util.Objects;

public class ValidityCheckersMoveException extends Exception {
    private boolean isValid;
    private ValidityErrorsCheckersMove error;

    public ValidityCheckersMoveException() {
        super();
        isValid = true;
    }

    public ValidityCheckersMoveException(ValidityErrorsCheckersMove error) {
        super();
        this.isValid = false;
        this.error = error;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ValidityCheckersMoveException)) {
            return false;
        }
        ValidityCheckersMoveException that = (ValidityCheckersMoveException) object;
        return isValid() == that.isValid() &&
                Objects.equals(getError(), that.getError());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid(), getError());
    }

    public boolean isValid() {
        return isValid;
    }

    public ValidityErrorsCheckersMove getError() {
        return error;
    }

}
