package com.example.health_checker.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum BodyPart {

    LEG(1,"leg"),
    ARM(2,"arm"),
    HEAD(3,"head"),
    SHOULDER(4,"shoulder"),
    ELBOW(5,"elbow"),
    KNEE(6,"knee"),
    NECK(7,"neck"),
    BACK(8,"back"),
    LOIN(9,"loin");

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
