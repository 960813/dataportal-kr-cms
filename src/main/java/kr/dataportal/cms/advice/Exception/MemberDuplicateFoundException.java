package kr.dataportal.cms.advice.exception;

import kr.dataportal.cms.advice.error.MemberError;

public class MemberDuplicateFoundException extends CommonException {
    public MemberDuplicateFoundException() {
        super(MemberError.DuplicateFound.getCode(), MemberError.DuplicateFound.getMessage());
    }
}
