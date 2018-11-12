package com.funsocietry.noq.api;

import com.funsocietry.noq.domain.TerminalResponse;
import com.funsocietry.noq.chache.ResponseCache;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Calendar;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class NoQController {

    private ResponseCache responseCache;

    @GetMapping("/time")
    public String time() {
        return Calendar.getInstance().getTime().toString();
    }
    @GetMapping("/_ah/health")
    public String healthy() {
        return "Still surviving.";
    }

    @GetMapping("/terminal/state")
    public TerminalResponse getState() throws IOException {
        return responseCache.getState();
    }

    @PostMapping("/consume")
    public void consumeData(@RequestBody TerminalResponse terminalResponse) {
        responseCache.writeCache(terminalResponse.getName(), terminalResponse);
    }
}
