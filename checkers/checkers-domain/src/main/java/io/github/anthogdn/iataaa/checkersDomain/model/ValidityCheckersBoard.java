package io.github.anthogdn.iataaa.checkersDomain.model;

import java.util.Objects;
import java.util.Set;

public class ValidityCheckersBoard {
    private boolean isValid;
    private Set<ValidityErrorCheckersBoard> errors;

    public ValidityCheckersBoard() {
        isValid = true;
    }

    public ValidityCheckersBoard(Set<ValidityErrorCheckersBoard> errors) {
        this.isValid = false;
        this.errors = errors;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ValidityCheckersBoard)) {
            return false;
        }
        ValidityCheckersBoard that = (ValidityCheckersBoard) object;
        return isValid() == that.isValid() &&
                Objects.equals(getErrors(), that.getErrors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid(), getErrors());
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Set<ValidityErrorCheckersBoard> getErrors() {
        return errors;
    }

    public void setErrors(Set<ValidityErrorCheckersBoard> errors) {
        this.errors = errors;
    }
}
