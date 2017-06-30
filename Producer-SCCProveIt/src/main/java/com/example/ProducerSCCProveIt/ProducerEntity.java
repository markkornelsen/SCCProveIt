package com.example.ProducerSCCProveIt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProducerEntity {
    private String value;
    private String timeSet;

    public ProducerEntity() {
    }

    public ProducerEntity(String value) {
        setValue(value);
    }

    public String getValue() {
        if (value == null)
            return "Producer Entity Value Not Set";
        return value;
    }

    public String getTimeSet() {
        if (timeSet == null)
            return "N/A";
        return timeSet;
    }

    public void setValue(String value) {
        this.value = value;
        this.timeSet = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}