package com.funsocietry.snippy.api;

import com.funsocietry.snippy.cache.ResponseCache;
import com.funsocietry.snippy.dto.SnippetRequest;
import com.funsocietry.snippy.dto.SnippetResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/snippet")
public class SnippyController {

    private ResponseCache responseCache;

    @GetMapping
    public SnippetResponse getState() throws IOException {
        return responseCache.getState();
    }

    @PostMapping
    public void createSnippet(@RequestBody SnippetRequest snippetRequest) {
        responseCache.writeCache(snippetRequest);
    }
}
