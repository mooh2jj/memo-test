package com.example.memotest.exception;

import lombok.Getter;

@Getter
public class MemoAPIException extends RuntimeException {

    private String entityName;
    private String fieldName;
    private final ErrorCode errorCode;
    
    public MemoAPIException(ErrorCode errorCode, String entityName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %d", entityName, fieldName, fieldValue));
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.errorCode = errorCode;
    }

    public MemoAPIException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
