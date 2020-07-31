package kr.dataportal.cms;

import kr.dataportal.cms.repository.SpringDataJpaMemberRepository;
import kr.dataportal.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;

    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(springDataJpaMemberRepository);
    }
}
