package com.funsocietry.vision.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ImageSnapshot {
    private String name;
    private long timestamp;
    private String data;
}
