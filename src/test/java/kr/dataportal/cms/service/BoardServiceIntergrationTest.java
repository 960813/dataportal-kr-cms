package kr.dataportal.cms.service;

import kr.dataportal.cms.domain.Board;
import kr.dataportal.cms.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySources({
        @TestPropertySource("/application-jpa.properties")
})
class BoardServiceIntergrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @Test
    void savePost() {
        Member member = memberService.findOne(1L).get();

        Board board = new Board();
        board.setTitle("TITLE");
        board.setContent("CONTENT");
        board.setOwner(member.getId());

        boardService.savePost(board);

        assertThat(boardService.findAllPosts().size()).isEqualTo(1);
    }

    @Test
    void findAllPosts() {
    }
}