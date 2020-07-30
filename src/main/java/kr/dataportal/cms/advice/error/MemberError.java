package kr.dataportal.cms.advice.error;

public enum MemberError implements InterfaceCommonError {
    OperationNotAuthorized(6000, "Operation not authorized"),
    DuplicateFound(6001, "이미 존재하는 회원입니다.");

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
