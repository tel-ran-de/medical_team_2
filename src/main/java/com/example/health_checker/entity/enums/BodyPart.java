package com.example.health_checker.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum BodyPart {
   ;

    private final Integer id;
    private final String name;

    @JsonCreator
    public static BodyPart getByName(String name) {
        return Arrays.stream(values())
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }

    @JsonValue
    public String getName() {
        return name;
    }
}