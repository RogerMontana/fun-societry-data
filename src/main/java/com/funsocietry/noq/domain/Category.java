package com.funsocietry.noq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Category {
    private long id;
    private String name;
}
