package com.ebidar.minioms.exception;

import com.ebidar.minioms.base.ApiError;
import com.ebidar.minioms.base.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    private final MessageSource messageSource;

    private <E extends BaseException> ResponseEntity<Object> buildResponseEntity(E exception, HttpStatus status) {
        ApiError apiError = new ApiError();
        apiError.setStatus(status)
                .setMessage(messageSource.getMessage(exception.getMessage(), exception.getParameters(), Locale.ENGLISH))
                .setParameters(exception.getParameters());
        return new ResponseEntity<>(apiError, status);
    }

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
        return buildResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return buildResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }
}
