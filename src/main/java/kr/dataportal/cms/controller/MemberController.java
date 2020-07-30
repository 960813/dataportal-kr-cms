package kr.dataportal.cms.controller;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user/members")
    public String listMembers(Model model) {
        List<Member> allMembers = memberService.findAllMembers();
        model.addAttribute("allMembers", allMembers);
        return "user/members";
    }

    // TODO: 2020-07-30 오후 2:45 회원가입 폼 Controller -Jinssssun
    @GetMapping("/user/signup")
    public String signupForm() {
        return "user/signup";
    }

    @PostMapping("/user/signup")
    public String signUp(MemberForm memberForm) {
        Member member = new Member();
        member.setUsername(memberForm.getUsername());
        member.setPassword(memberForm.getPassword());
        member.setAuthId("local:" + member.getUsername());
        member.setDisplayName(memberForm.getDisplayName());
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/user/signin")
    public String signInForm() {
        return "user/signin";
    }

    /**
     * 접근 거부 페이지
     *
     * @return
     */
    public String dispDenied() {
        return "/denied";
    }

    /**
     * 내 정보 페이지
     *
     * @return
     */
    @GetMapping("/user/info")
    public String dispMyInfo(Principal principal, Model model) {
        String displayName = memberService.findOne(principal.getName()).get().getDisplayName();
        model.addAttribute("displayName", displayName);
        return "/user/info";
    }

    /**
     * 어드민 페이지
     *
     * @return
     */
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
