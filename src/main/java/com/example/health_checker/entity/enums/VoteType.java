package com.example.health_checker.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum VoteType {
    SORRY(1, "sorry"),
    ADMIRE(2, "admire")
    ;

    private final Integer id;
    private final String name;

    @JsonValue
    public String getName(){
        return name;
    }
    @JsonCreator
    public static VoteType getByName(String name){
        return Arrays.stream(values())
                .filter(x-> x.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }
}
