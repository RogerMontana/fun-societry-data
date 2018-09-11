package com.funsocietry.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by artem on 9/11/18.
 */
@RestController
public class Controller {
    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot, I'm on App Engine!!!";
    }
    @GetMapping("/time")
    public String time() {
        return Calendar.getInstance().getTime().toString();
    }
    @GetMapping("/_ah/health")
    public String healthy() {
        return "Still surviving.";
    }
}
