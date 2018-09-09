package com.funsocietry.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@SpringBootApplication
@RestController
public class DataCollectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectorServiceApplication.class, args);
	}

    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot, I'm on App Engine!!!";
    }
    @RequestMapping("/time")
    public String time() {
        return Calendar.getInstance().getTime().toString();
    }
    @RequestMapping("/_ah/health")
    public String healthy() {
        return "Still surviving.";
    }
}
