package io.scheduler.mapper;

import io.scheduler.domain.Schema;
import io.scheduler.domain.dto.PlaceDTO;
import io.scheduler.domain.schedule.Day;
import io.scheduler.domain.schedule.Place;
import io.scheduler.domain.schedule.Shift;
import io.scheduler.exception.WrongDayDefinitionException;
import io.scheduler.exception.WrongShiftDefinitionException;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaceMapper {

    public Place convert(PlaceDTO dto, Schema schema) {

        List<Day> days = dto.getDefinition().entrySet().stream().map((entry) -> {
            if (!schema.containsDay(entry.getKey())) {
                throw new WrongDayDefinitionException();
            }

            List<Shift> shifts = convertShift(schema, entry.getValue().entrySet());
            Schema.SchemaData daySchema = schema.getDaySchema(entry.getKey());

            return new Day(daySchema.getId(), daySchema.getName(), shifts);
        }).collect(Collectors.toList());

        return new Place(dto.getUuid(), dto.getName(), days);
    }

    private List<Shift> convertShift(Schema schema, Set<Entry<String, Integer>> entryDay) {
        return entryDay.stream().map((entry) -> {
            if (!schema.containsShift(entry.getKey())) {
                throw new WrongShiftDefinitionException();
            }
            Schema.SchemaData shiftSchema = schema.getShiftSchema(entry.getKey());
            return new Shift(shiftSchema.getId(), shiftSchema.getName(), entry.getValue());
        }).collect(Collectors.toList());
    }
}
