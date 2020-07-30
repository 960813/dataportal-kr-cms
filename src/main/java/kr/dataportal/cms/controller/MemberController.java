package kr.dataportal.cms.controller;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // TODO: 2020-07-30 오후 2:45 회원가입 폼 Controller -Jinssssun
    @GetMapping("/members/new")
    public String createMembersForm() {
        return "members/newMembersForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberForm memberForm) {
        Member member = new Member();
        member.setUserName(memberForm.getUserName());
        member.setPassword(memberForm.getPassword());
        member.setAuthId("local:" + member.getUserName());
        member.setDisplayName(memberForm.getDisplayName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String listMember(Model model) {
        List<Member> allMembers = memberService.findAllMembers();
        model.addAttribute("allMembers", allMembers);
        return "members/list";
    }
}
