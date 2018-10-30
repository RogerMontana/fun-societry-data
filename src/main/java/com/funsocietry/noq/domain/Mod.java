package com.funsocietry.noq.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Mod {
    private long id;
    private String name;
    private long maxNumber;
    private BigDecimal price;
    private List<Long> combinedWith;
}
