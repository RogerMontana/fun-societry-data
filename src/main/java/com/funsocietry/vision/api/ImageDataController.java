package com.funsocietry.vision.api;

import com.funsocietry.vision.domain.ImageSnapshot;
import com.funsocietry.vision.chache.ImageCache;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ImageDataController {

    private ImageCache imageCache;

    @GetMapping("/time")
    public String time() {
        return Calendar.getInstance().getTime().toString();
    }
    @GetMapping("/_ah/health")
    public String healthy() {
        return "Still surviving.";
    }

    @GetMapping("/cache/health")
    public ImageSnapshot checkCache() {
        return imageCache.health();
    }

    @PostMapping("/consume")
    public void consumeData(@RequestBody ImageSnapshot imageSnapshot) {
        imageCache.writeCache(imageSnapshot.getName(), imageSnapshot);
    }
}