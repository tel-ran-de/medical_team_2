package com.example.health_checker.service;

import com.example.health_checker.entity.StoryParams;
import org.json.JSONArray;

import java.util.HashMap;

public interface CountingService {

    Integer countingScores(JSONArray jsonArrayAnswers);

    Integer countingBMI(JSONArray jsonArrayBMI);
}
