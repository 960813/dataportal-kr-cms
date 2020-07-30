package kr.dataportal.cms.advice.exception;

public class CommonException extends RuntimeException {
    private int ERR_CODE;
    private String ERR_MSG;

    CommonException(int code, String msg) {
        this.ERR_CODE = code;
        this.ERR_MSG = msg;
    }

    int getERR_CODE() {
        return this.ERR_CODE;
    }

    String getERR_MSG() {
        return this.ERR_MSG;
    }
}
