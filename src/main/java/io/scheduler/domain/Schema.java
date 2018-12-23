package io.scheduler.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Map;

public class Schema {
    @JsonUnwrapped(prefix = "days")
    private Map<Integer, String> days;
    @JsonUnwrapped(prefix = "shifts")
    private Map<Integer, String> shifts;

    @Override
    public String toString() {
        return "Schema{" +
                "days=" + days +
                ", shifts=" + shifts +
                '}';
    }
}
