package com.example.memotest.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {

    SUCCESS_CODE(1000, "성공"),
    FAIL_CODE(1001, "실패"),
    NO_SEARCH_DATA_CODE(1002, "해당 데이터가 존재하지 않습니다."),
    ARGUMENT_NOT_VALID_CODE(1003, "요청 값을 확인해주세요."),
    NO_HANDLER_FOUND_CODE(1004, "존재하지 않는 페이지입니다."),
    NO_USER_CODE(1005, "존재하지 않는 회원입니다."),
    NOT_FOUND_USER_CODE(1006, "존재하지 않는 회원입니다."),
    NO_LOGIN_CODE(1007, "로그인이 되지 않았거나 유저 정보가 없습니다."),
    NO_HEADER_KEY_CODE(1008, "헤더 정보를 확인해주세요."),
    INVALID_HEADER_KEY_CODE(1009, "잘못된 헤더 정보 입니다."),
    METHOD_NOT_SUPPORT_CODE(1010, "HTTP METHOD를 확인해주세요."),
    INVALID_USER_ID_CODE(1011, "유저 Email을 확인해주세요."),
    INVALID_USER_PASSWORD_CODE(1012, "비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요."),
    INVALID_TOKEN_CODE(1013, "잘못된 토큰 입니다. 토큰 정보를 확인해주세요."),
    NO_BODY_CODE(1014, "BODY 정보를 확인해주세요."),
    INVALID_NUMBER_FORMAT_CODE(1015, "잘못된 타입의 데이터입니다. 데이터 타입을 확인해주세요."),
    INVALID_PHONE_NUM(1016, "유효하지 인증수단 입니다. 입력된 값을 확인해주세요."),
    INVALID_AUTH_NUM(1017, "유효하지 않은 인증번호 입니다. 입력된 값을 확인해주세요."),
    RAZORPAY_FAIL_CODE(1018, "RAZORPAY 통신 중 오류가 발생했습니다."),
    PAYMENT_VALIDATION_FAIL_CODE(1019, "요청 데이터 내 멤버십 가격 정보와 DB 내 멤버십 가격 정보가 일치하지 않습니다."),
    OVERLAP_PHONE_NUM(1020, "이미 등록 된 휴대폰 번호 입니다. 휴대폰 번호를 확인해 주세요."),
    DUPLICATED_EMAIL(1021, "이미 등록 된 Email 입니다. E-mail을 확인해 주세요."),
    NOT_OPEN_RECRUITMENT(1022, "OPEN 상태인 공고가 아닙니다."),
    REDUNDANT_SUPPORT_CODE(1023, "이미 지원한 공고입니다."),
    UPDATE_PASSWORD_CODE(1024, "변경할 비밀번호가 서로 일치하지 않습니다. 다시 확인 후 입력해 주세요."),
    CHECK_PASSWORD_CODE(1025, "회원정보에 등록 된 비밀번호와 일치하지 않습니다."),
    INPUT_TEXT_CHECK_CODE(1026, "입력 된 텍스트가 일치 하지 않습니다."),
    EXPIRED_JWT_CODE(1027, "Access Token이 만료되었습니다. Refresh Token을 보내 Token을 재발급해주세요."),
    INVALID_REFRESH_TOKEN_CODE(1028, "Refresh Token이 만료되었거나 잘못된 토큰 정보 입니다. 재로그인해주세요."),
    AWS_S3_FILE_UPLOAD_FAIL_CODE(1029, "파일 업로드에 실패했습니다. 잠시 후 다시 시도해주세요."),
    AWS_S3_FILE_DELETE_FAIL_CODE(1030, "파일 삭제를 실패했습니다. 잠시 후 다시 시도해주세요.");

    private final Integer code;
    private final String message;
}
