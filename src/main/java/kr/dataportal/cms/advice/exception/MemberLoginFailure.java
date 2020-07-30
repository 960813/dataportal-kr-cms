package kr.dataportal.cms.advice.exception;

import kr.dataportal.cms.advice.error.MemberError;

public class MemberLoginFailure extends CommonException {
    public MemberLoginFailure() {
        super(MemberError.LoginFailure.getCode(), MemberError.LoginFailure.getMessage());
    }
}
