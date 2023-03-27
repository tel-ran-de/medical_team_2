package com.example.health_checker.service.impl;

import com.example.health_checker.service.CountingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class CountingServiceImpl implements CountingService {

    private int group1 = 0, group2 = 0, group3 = 0, group4 = 0, group5 = 0, group6 = 0, total = 0;

    @Override
    public Integer countingScores(String request) {
        log.info("accept json answers and counting according data inside and return Integer value ");
        JSONObject jsonObject = new JSONObject(request);
        JSONArray jsonArrayAnswers = jsonObject.getJSONArray("user_data");
        for (int i = 0; i < jsonArrayAnswers.length(); i++) {
            JSONObject jsonObjectAnswer = jsonArrayAnswers.getJSONObject(i);
            if (jsonObjectAnswer.has("user_answers")) {
                JSONArray jsonArrayResult = jsonObjectAnswer.getJSONArray("user_answers");
                for (int j = 0; j < jsonArrayResult.length(); j++) {
                    int score = jsonArrayResult.getInt(j);
                    // Questions # 1, 2, 20, 22, 34, 36
                    if (j == 0 || j == 1 || j == 19 || j == 21 || j == 33 || j == 35) {
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
                    if (j > 1 && j < 12) {
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
                    if (j > 11 && j < 19) {
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
                    if (j == 20 || j == 22 || j == 25 || j == 26 || j == 29) {
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
                    if (j == 23 || j == 24 || j == 27 || j == 28 || j == 30) {
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
                    if (j == 31 || j == 32 || j == 34) {
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
            }
        }
        total = (group1 / 6 + group2 / 10 + group3 / 7 + group4 / 5 + group5 / 5 + group6 / 3) / 6;
        return total;

    }


    @Override
    public Integer countingUserBMI(String request) {
        log.info("accept json data and counting BMI score and return Integer value");
        int weight = 0;
        int height = 0;
        JSONObject jsonObject = new JSONObject(request);
        JSONArray jsonArrayAnswers = jsonObject.getJSONArray("user_data");
        for (int i = 0; i < jsonArrayAnswers.length(); i++) {
            JSONObject jsonObjectAnswer = jsonArrayAnswers.getJSONObject(i);
            if (jsonObjectAnswer.has("user_bmi")) {
                if (jsonObjectAnswer.has("weight")) {
                    weight = Integer.parseInt(jsonObjectAnswer.getString(String.valueOf(Integer.parseInt(String.valueOf(i)))));
                }
                if (jsonObjectAnswer.has("height")) {
                    height = Integer.parseInt(jsonObjectAnswer.getString(String.valueOf(Integer.parseInt(String.valueOf(i)))));
                }
            }
        }
        return weight / (height * height);
    }

}