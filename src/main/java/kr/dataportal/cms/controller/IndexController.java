package kr.dataportal.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: 2020-07-30 오후 1:39 IndexContoller 생성 -Jinssssun
@Controller
public class IndexController {

    @GetMapping("/")
    public String Index(Model model) {
        return "index";
    }
}
