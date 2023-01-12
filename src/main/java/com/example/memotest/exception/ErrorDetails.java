package com.example.memotest.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime dateTime;
    private String message;
    private String details;

    private ErrorCode errorCode;

    private String errorMsg;

    @Builder
    public ErrorDetails(LocalDateTime dateTime, String message, String details, ErrorCode errorCode, String errorMsg) {
        this.dateTime = dateTime;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
