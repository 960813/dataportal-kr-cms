package kr.dataportal.cms.advice.error;

public enum MemberError implements InterfaceCommonError {
    DoesNotExist(6000, "존재하지 않는 회원입니다."),
    DuplicateFound(6001, "이미 존재하는 회원입니다."),
    LoginFailure(6002, "로그인에 실패하였습니다.");

    private int code;
    private String message;

    MemberError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
