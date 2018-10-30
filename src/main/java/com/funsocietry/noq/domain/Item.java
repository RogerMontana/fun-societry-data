package com.funsocietry.noq.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Item {
    private long id;
    private long categoryId;
    private String name;
    private boolean isModifiable;
    private BigDecimal itemPrice;
}
