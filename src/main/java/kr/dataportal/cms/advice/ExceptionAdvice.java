package kr.dataportal.cms.advice;

import kr.dataportal.cms.advice.Exception.MemberDuplicateFoundException;
import kr.dataportal.cms.advice.error.MemberError;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MemberDuplicateFoundException.class)
    public String MemberDuplicateFoundException(Model model) {
        model.addAttribute("ERR_MSG", MemberError.DuplicateFound.getMessage());
        return "/user/register";
    }
}
