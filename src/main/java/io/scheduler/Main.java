package io.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File schemaFile = new File("src/main/resources/data/schema.json");
        Schema schema = objectMapper.readValue(schemaFile, Schema.class);
        System.out.println(schema.toString());
    }
}
