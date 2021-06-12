package com.orangeChallenge.orangeChallenge.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    private final String title;
    private final Integer status;
    private final List<Field> fields;

    public Error(String title, Integer status, List<Field> fields){
        this.title = title;
        this.status = status;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStatus() {
        return status;
    }

    public List<Field> getFields() {
        return fields;
    }

    public static class Field{
        private final String name;
        private final String message;

        public Field(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }
    }
}
