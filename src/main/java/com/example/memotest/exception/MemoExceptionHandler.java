package com.example.memotest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class MemoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemoAPIException.class)
    public ResponseEntity<Object> handleExceptionInternal(
            MemoAPIException ex,
            WebRequest request) {
        log.error("MemoAPIException: ",ex);

        ErrorDetails errorDetails = ErrorDetails.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .errorCode(ex.getErrorCode())
                .errorMsg(ex.getErrorCode().getErrorMsg())
                .build();

        return new ResponseEntity<>(errorDetails, mapToStatus(errorDetails.getErrorCode()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedExceptionInternal(
            MemoAPIException ex,
            WebRequest request) {
        log.error("AccessDeniedException: ",ex);

        ErrorDetails errorDetails = ErrorDetails.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .errorCode(ex.getErrorCode())
                .errorMsg(ex.getErrorCode().getErrorMsg())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    private HttpStatus mapToStatus(ErrorCode errorCode) {

        switch (errorCode) {
            case NO_FOUND_ENTITY:
                return HttpStatus.NOT_FOUND;
            case DUPLICATED_ENTITY:
                return HttpStatus.CONFLICT;
            case INVALID_REQUEST:
                return HttpStatus.BAD_REQUEST;
            case NOT_FOUND_USER:
                return HttpStatus.UNAUTHORIZED;
            default: // 나머지는 모두 INTERNAL_SERVER_ERROR 처리
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
