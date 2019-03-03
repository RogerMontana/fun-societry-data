package com.funsocietry.snippy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class SnippetRequest {
    private String name;
    private String uid;
    private long timestamp;
    private List<Lang> langs;
    private String code;
}
