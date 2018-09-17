package com.funsocietry.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageSnapshot {
    private String name;
    private long timestamp;
    private String data;
}
