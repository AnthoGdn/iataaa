package io.github.anthogdn.iataaa.checkersApi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends EntityNotFoundException implements RestException {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

    public NotFoundException(String entityName, String propertyValue, String propertyName) {
        super(entityName + " entity with " + propertyValue + " " + propertyName + " is not found");
        LOGGER.info("{} entity with {} {} is not found", entityName, propertyValue, propertyName);
    }
}
