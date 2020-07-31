package kr.dataportal.cms;

import kr.dataportal.cms.repository.SpringDataJpaBoardRepository;
import kr.dataportal.cms.repository.SpringDataJpaMemberRepository;
import kr.dataportal.cms.service.BoardService;
import kr.dataportal.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;
    private final SpringDataJpaBoardRepository springDataJpaBoardRepository;

    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository, SpringDataJpaBoardRepository springDataJpaBoardRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
        this.springDataJpaBoardRepository = springDataJpaBoardRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(springDataJpaMemberRepository);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(springDataJpaBoardRepository);
    }
}
