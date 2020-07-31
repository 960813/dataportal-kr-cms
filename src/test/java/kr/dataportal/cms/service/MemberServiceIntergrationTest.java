package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Member;
import kr.dataportal.cms.repository.SpringDataJpaMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestPropertySources({
        @TestPropertySource("/application-jpa.properties")
})
class MemberServiceIntergrationTest {

    @Autowired
    MemberService memberService;


    @Test
    void 아이디_기반_회원_조회() {
        Member member = new Member();
        member.setUsername("TEST");
        member.setAuthId("local:" + member.getUsername());
        member.setPassword("PW");
        member.setDisplayName("NAME");

        Member result = memberService.findOne(memberService.join(member)).get();

        Assertions.assertThat(result.getUsername()).isEqualTo(member.getUsername());
    }
}