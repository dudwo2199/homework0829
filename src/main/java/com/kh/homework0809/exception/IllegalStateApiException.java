package com.kh.homework0809.exception;

import lombok.Getter;

@Getter
public class IllegalStateApiException extends IllegalStateException {
    private final ErrorCode errorCode;

    public IllegalStateApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
