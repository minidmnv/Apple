package pl.minidmnv.apple.source.fixture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.minidmnv.apple.source.exception.FSConnectionException;
import pl.minidmnv.apple.source.exception.ResourceNotFoundException;

/**
 * @author minidmnv
 */
@ControllerAdvice(assignableTypes = {FixturesController.class})
public class FixturesControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFound() {
        return "There is no resource found for given input";
    }

    @ExceptionHandler(FSConnectionException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public String handleFSConnection() {
        return "There are some problems with repository service";
    }

}
