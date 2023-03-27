package com.example.health_checker.service;

import com.example.health_checker.entity.enums.BodyPart;

public interface StoryService {
    /**
     *
     * @param bodyPart
     */
    void chooseBodyPart(BodyPart bodyPart);

    /**
     *
     * @param problem
     * @param id
     */
    void describeProblem(String problem, int id);
}
