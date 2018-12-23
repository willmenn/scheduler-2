package io.scheduler.domain.dto;

import java.util.Map;
import java.util.UUID;

public class PlaceDTO {
    private UUID uuid;
    private String name;
    private Map<String, Integer> daysByMaxNumberOfPossibleScheduled;
}
