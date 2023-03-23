package com.example.health_checker.service;

import com.example.health_checker.entity.StoryParams;

import java.util.HashMap;

public interface StoryParamService {
    /**
     *
     * @param params
     * @return
     */
    HashMap<Integer, Integer> getMapOfAnswers(StoryParams params);

    Integer countingScores(StoryParams params);

    HashMap<String, Integer> getMapOfBMI(StoryParams params);

    Integer countingBMI(StoryParams params);
}
