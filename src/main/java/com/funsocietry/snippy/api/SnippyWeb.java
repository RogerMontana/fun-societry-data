package com.funsocietry.snippy.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class SnippyWeb {

    @GetMapping
    public String index() {
        return "index.html";
    }

}
