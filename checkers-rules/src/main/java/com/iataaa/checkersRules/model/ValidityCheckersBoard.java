package com.iataaa.checkersRules.model;

import java.util.List;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidityCheckersBoard)) return false;
        ValidityCheckersBoard that = (ValidityCheckersBoard) o;
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