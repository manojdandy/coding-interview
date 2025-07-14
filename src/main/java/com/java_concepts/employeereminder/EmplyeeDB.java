package com.java_concepts.employeereminder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java_concepts.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmplyeeDB {
    public static void main(String[] args) throws IOException {
        Employee employee = findEmployees().stream().filter(e ->"TRUE".equals(e.getNewJoiner()))
                        .findAny().orElse(null);
        System.out.println(employee);
    }
    public static List<Employee> findEmployees() {
        File file = new File("/Users/manojbeniwal/intelij/coding-interview/src/main/resources/dataset/employees.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = null;
        try {
            employees = mapper.readValue(file, new TypeReference<List<Employee>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employees;

    }
}
