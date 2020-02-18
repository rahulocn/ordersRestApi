package com.swamirahul10.demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateIds {
    public static final String generateOrderID() {
        return "ORD" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }
}
