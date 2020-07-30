package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setDisplayName("Jin TaeYang");
        member.setUserName("taeyang");
        member.setPassword(member.getUserName() + "password");

        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
        assertTrue(encoder.matches(member.getUserName() + "password", member.getPassword()));
    }

    @Test
    void findAllMembers() {
    }

    @Test
    void findOne() {
    }
}