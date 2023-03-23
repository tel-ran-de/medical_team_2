package com.example.health_checker.service;

import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.repository.StoryParamsRepository;
import com.example.health_checker.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StoryParamsService {

    private final StoryParamsRepository paramsRepository;

    private final StoryRepository storyRepository;

    private Integer group1, group2, group3, group4, group5, group6, total;

    @Autowired
    public StoryParamsService(StoryParamsRepository paramsRepository, StoryRepository storyRepository) {
        this.paramsRepository = paramsRepository;
        this.storyRepository = storyRepository;
    }

    public HashMap<Integer, Integer> getMapOfAnswers(StoryParams params) {//изменить параметр на стринг или
        Integer value = Integer.valueOf(params.getValue());
        Integer key = Integer.valueOf(params.getId());
        HashMap<Integer, Integer> answers = new HashMap<>();
        answers.put(key, value);
        return answers;//посчитать и сохранить вопросы
    }

    public Integer countingScores(StoryParams params) {
        HashMap<Integer, Integer> answers = getMapOfAnswers(params);
        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            Integer score = entry.getValue();

            // Questions # 1, 2, 20, 22, 34, 36
            if (entry.getKey() == 0 || entry.getKey() == 1 || entry.getKey() == 19
                    || entry.getKey() == 21 || entry.getKey() == 33
                    || entry.getKey() == 35) {
                switch (score) {
                    case 1:
                        score = 100;
                        break;
                    case 2:
                        score = 75;
                        break;
                    case 3:
                        score = 50;
                        break;
                    case 4:
                        score = 25;
                        break;
                    case 5:
                        score = 0;
                        break;
                }
                group1 = group1 + score;
            }

            // Questions # 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
            if (entry.getKey() > 1 && entry.getKey() < 12) {
                switch (score) {
                    case 1:
                        score = 0;
                        break;
                    case 2:
                        score = 50;
                        break;
                    case 3:
                        score = 100;
                        break;
                }
                group2 = group2 + score;
            }

            // Questions # 13, 14, 15, 16, 17, 18, 19
            if (entry.getKey() > 11 && entry.getKey() < 19) {
                switch (score) {
                    case 1:
                        score = 0;
                        break;
                    case 2:
                        score = 100;
                        break;
                }
                group3 = group3 + score;
            }

            // Questions # 21, 23, 26, 27, 30
            if (entry.getKey() == 20 || entry.getKey() == 22 || entry.getKey() == 25
                    || entry.getKey() == 26 || entry.getKey() == 29) {
                switch (score) {
                    case 1:
                        score = 100;
                        break;
                    case 2:
                        score = 80;
                        break;
                    case 3:
                        score = 60;
                        break;
                    case 4:
                        score = 40;
                        break;
                    case 5:
                        score = 20;
                        break;
                    case 6:
                        score = 0;
                        break;
                }
                group4 = group4 + score;
            }

            // Questions # 24, 25, 28, 29, 31
            if (entry.getKey() == 23 || entry.getKey() == 24 || entry.getKey() == 27
                    || entry.getKey() == 28 || entry.getKey() == 30) {
                switch (score) {
                    case 1:
                        score = 0;
                        break;
                    case 2:
                        score = 20;
                        break;
                    case 3:
                        score = 40;
                        break;
                    case 4:
                        score = 60;
                        break;
                    case 5:
                        score = 80;
                        break;
                    case 6:
                        score = 100;
                        break;
                }
                group5 = group5 + score;
            }

            // Questions # 32, 33, 35
            if (entry.getKey() == 31 || entry.getKey() == 32 || entry.getKey() == 34) {
                switch (score) {
                    case 1:
                        score = 0;
                        break;
                    case 2:
                        score = 25;
                        break;
                    case 3:
                        score = 50;
                        break;
                    case 4:
                        score = 75;
                        break;
                    case 5:
                        score = 100;
                        break;
                }
                group6 = group6 + score;
            }
        }

        total = (group1 / 6 + group2 / 10 + group3 / 7 + group4 / 5 + group5 / 5 + group6 / 3) / 6;
        return total;
    }

    public HashMap<String, Integer> getMapOfBMI(StoryParams params) {
        Integer value = Integer.valueOf(params.getValue());
        String key = String.valueOf(params.getId());
        HashMap<String, Integer> answers = new HashMap<>();
        answers.put(key, value);
        return answers;
    }

    public Integer countingBMI(Integer height,Integer weight,Integer age,StoryParams params) {
        HashMap<String, Integer> answers = getMapOfBMI(params);
         height = answers.get("height");
         weight = answers.get("weight");
        return weight / (height * height);
    }
}
