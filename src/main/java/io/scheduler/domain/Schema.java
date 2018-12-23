package io.scheduler.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Map;

public class Schema {
    @JsonUnwrapped(prefix = "days")
    private Map<Integer, String> days;
    @JsonUnwrapped(prefix = "shifts")
    private Map<Integer, String> shifts;

    public boolean containsDay(String day) {
        return this.days.containsKey(day);
    }

    public boolean containsShift(String shift) {
        return this.shifts.containsKey(shift);
    }

    public SchemaData getShiftSchema(String name) {
        return shifts.entrySet().stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(entry -> new SchemaData(entry.getKey(), entry.getValue()))
                .findFirst().get();
    }

    public SchemaData getDaySchema(String name) {
        return days.entrySet().stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(entry -> new SchemaData(entry.getKey(), entry.getValue()))
                .findFirst().get();
    }

    public class SchemaData {
        private int id;
        private String name;

        public SchemaData(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public String toString() {
        return "Schema{" +
                "days=" + days +
                ", shifts=" + shifts +
                '}';
    }
}
