package com.example.ConsumerSCCProveIt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsumerEntity {
    private String value;
    private String timeSet;

    public ConsumerEntity() {
    }

    public ConsumerEntity(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public String getTime() {
        return timeSet;
    }

    public void setValue(String value) {
        this.value = value;
        this.timeSet = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}