package kr.dataportal.cms.advice;

import kr.dataportal.cms.advice.exception.MemberDoesNotExist;
import kr.dataportal.cms.advice.exception.MemberDuplicateFoundException;
import kr.dataportal.cms.advice.error.MemberError;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MemberDoesNotExist.class)
    public String MemberDoesNotExist(Model model) {
        model.addAttribute("ERR_MSG", MemberError.DoesNotExist.getMessage());
        return "/user/login";
    }

    @ExceptionHandler(MemberDuplicateFoundException.class)
    public String MemberDuplicateFoundException(Model model) {
        model.addAttribute("ERR_MSG", MemberError.DuplicateFound.getMessage());
        return "/user/register";
    }


}
