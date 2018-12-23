package io.scheduler.domain.dto;

import java.util.Map;
import java.util.UUID;

public class PlaceDTO {
    private UUID uuid;
    private String name;
    private Map<String, Map<String, Integer>> daysByShiftByMaxNumberOfPossibleScheduled;

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Map<String, Map<String, Integer>> getDefinition() {
        return daysByShiftByMaxNumberOfPossibleScheduled;
    }
}
