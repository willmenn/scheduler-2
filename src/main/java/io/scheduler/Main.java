package io.scheduler;

import io.scheduler.domain.Schema;
import io.scheduler.parser.Parser;

public class Main {
    public static void main(String[] args) {
        String pathname = "src/main/resources/data/schema.json";
        Parser parser = new Parser();
        Schema schema = parser.getObject(pathname, Schema.class);
        System.out.println(schema.toString());
    }
}
