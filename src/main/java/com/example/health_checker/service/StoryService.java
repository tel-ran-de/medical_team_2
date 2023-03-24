package com.example.health_checker.service;

import com.example.health_checker.entity.enums.BodyPart;

public interface StoryService {
    void chooseBodyPart(BodyPart bodyPart);

    void describeProblem(String problem, int id);
}
