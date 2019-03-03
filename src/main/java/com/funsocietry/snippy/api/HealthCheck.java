package com.funsocietry.snippy.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@AllArgsConstructor
@RequestMapping("/check")
public class HealthCheck {

    @GetMapping("/time")
    public String time() {
        return Calendar.getInstance().getTime().toString();
    }

    @GetMapping("/_ah/health")
    public String healthy() {
        return "Still surviving.";
    }

}
