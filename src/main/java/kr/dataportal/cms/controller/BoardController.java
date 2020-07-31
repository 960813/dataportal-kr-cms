package kr.dataportal.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public String boardList() {
        return "board/list";
    }

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String boardWrite() {
        return "board/write";
    }
}
