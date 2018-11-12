package com.funsocietry.noq.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class TerminalResponse {
    private String name;
    private long timestamp;
    private List<Category> categories;
    private List<Item> items;
    private List<Mod> mods;
    private QrCode paymentQrCode;
}
