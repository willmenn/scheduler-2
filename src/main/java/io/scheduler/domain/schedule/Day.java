package io.scheduler.domain.schedule;

import java.util.List;

public class Day {
    private int id;
    private String name;
    private List<Shift> shifts;

    public Day(int id, String name, List<Shift> shifts) {
        this.name = name;
        this.id = id;
        this.shifts = shifts;
    }
}
