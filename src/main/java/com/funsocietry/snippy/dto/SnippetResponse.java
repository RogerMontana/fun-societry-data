package com.funsocietry.snippy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class SnippetResponse {
    private String name;
    private String link;
    private ImgSnippet snippet;
}
