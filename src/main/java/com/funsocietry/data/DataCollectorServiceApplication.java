package com.funsocietry.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController
public class DataCollectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectorServiceApplication.class, args);
	}

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
