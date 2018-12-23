package io.scheduler.domain.schedule;

import java.util.ArrayList;
import java.util.List;

public class Shift {
    private int id;
    private String name;
    private int allocation;
    private List<ObjectScheduled> objects;

    public Shift(int id, String name, int allocation) {
        this.allocation = allocation;
        this.objects = new ArrayList<>();
    }
}
