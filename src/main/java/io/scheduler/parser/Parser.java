package io.scheduler.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.scheduler.exception.ConfigNotFoundException;

import java.io.File;
import java.io.IOException;

public class Parser {

    private ObjectMapper objectMapper;

    public Parser() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> T getObject(String pathClass, Class<T> clazz) {
        File schemaFile = new File(pathClass);
        try {
            return objectMapper.readValue(schemaFile, clazz);
        } catch (IOException e) {
            throw new ConfigNotFoundException();
        }
    }
}
