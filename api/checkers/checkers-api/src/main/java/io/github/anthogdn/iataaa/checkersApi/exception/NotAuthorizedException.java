package io.github.anthogdn.iataaa.checkersApi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotAuthorizedException extends Exception implements RestException {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

    private CodeException code;

    public NotAuthorizedException(String propertyName, String id, CodeException code) {
        super(code.getMessage());
        this.code = code;
        LOGGER.info("{}: {} - Reason: {}", propertyName, id, code);
    }

    public CodeException getCode() {
        return code;
    }
}
