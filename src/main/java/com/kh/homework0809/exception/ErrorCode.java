package com.kh.homework0809.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    // Account
    FAILED_TO_SIGNUP("ACCOUNT", -1, "회원가입에 실패했습니다.")
    , DUPLICATE_ACCOUNT_ID("ACCOUNT", 1000, "이미 사용중인 아이디입니다.")
    , NOT_FOUND_ACCOUNT("ACCOUNT", 1001, "계정이 존재하지 않습니다.")
    , INVALID_PASSWORD("ACCOUNT", 1002, "비밀번호가 일치하지 않습니다.")
    , FAILED_MODIFY_PASSWORD("ACCOUNT", 1003, "비밀번호 변경에 실패했습니다.")
    , SHORT_PASSWORD_LENGTH("ACCOUNT", 1004, "비밀번호 길이가 잛습니다. 8자 이상이어야 합니다.")
    , FAILED_TO_DELETE_ACCOUNT("ACCOUNT", 1005, "계정 삭제에 실패했습니다.")
;
    private final String domain;
    private final int statusCode;
    private final String message;
}
