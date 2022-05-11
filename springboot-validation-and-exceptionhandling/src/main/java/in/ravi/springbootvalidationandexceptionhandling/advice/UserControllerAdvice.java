package in.ravi.springbootvalidationandexceptionhandling.advice;

import in.ravi.springbootvalidationandexceptionhandling.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserControllerAdvice {

    private Map<String, String> errorMap = new HashMap<>();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String, String> validationExceptionHandler(MethodArgumentNotValidException exception) {
        exception.getFieldErrors().stream().forEach(
                error -> errorMap.put(error.getField(), error.getDefaultMessage())
        );
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    private Map<String, String> userNotFoundException(UserNotFoundException userNotFoundException) {
        errorMap.put("Error Message", userNotFoundException.getMessage());
        return errorMap;
    }
}
