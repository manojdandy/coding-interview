package com.java_concepts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ObjectMapperTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper  = new ObjectMapper();
        File file = new File("/Users/manojbeniwal/intelij/coding-interview/src/main/resources/emp.json");
       List<Employee> emps =  mapper.readValue(file, new TypeReference<List<Employee>>() {
        });
        System.out.println(emps);
    }
}
