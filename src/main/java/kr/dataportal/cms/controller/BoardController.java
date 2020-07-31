package kr.dataportal.cms.controller;

import kr.dataportal.cms.domain.Board;
import kr.dataportal.cms.service.BoardService;
import kr.dataportal.cms.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;

    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("allBoards", boardService.findAllPosts());
        return "board/list";
    }

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String boardWrite(BoardForm boardForm, Principal principal) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent().replace("\r\n", "<br/>"));
        board.setOwner(memberService.findOne(principal.getName()).get().getId());

        boardService.savePost(board);


        return "redirect:/board/list";
    }
}
