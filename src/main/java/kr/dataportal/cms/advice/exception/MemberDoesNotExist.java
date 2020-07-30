package kr.dataportal.cms.advice.exception;

import kr.dataportal.cms.advice.error.MemberError;

public class MemberDoesNotExist extends CommonException {
    public MemberDoesNotExist() {
        super(MemberError.DoesNotExist.getCode(), MemberError.DoesNotExist.getMessage());
    }
}
