package com.funsocietry.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class StaticUIController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
