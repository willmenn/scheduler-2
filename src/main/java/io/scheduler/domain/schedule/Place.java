package io.scheduler.domain.schedule;

import java.util.List;
import java.util.UUID;

public class Place {
    private UUID uuid;
    private String name;
    private List<Day> days;

    public Place(UUID uuid, String name, List<Day> days) {
        this.uuid = uuid;
        this.name = name;
        this.days = days;
    }
}
