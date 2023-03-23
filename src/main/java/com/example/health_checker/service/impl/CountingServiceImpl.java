package com.example.health_checker.service.impl;

import com.example.health_checker.service.CountingService;
import com.example.health_checker.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CountingServiceImpl implements CountingService {

    private final ParsingService parsingService;

    private Integer group1, group2, group3, group4, group5, group6, total;

@Override
    public Integer countingScores(JSONArray jsonArrayAnswers) {
        for (int i = 0; i < jsonArrayAnswers.length(); i++) {
            int score = Integer.parseInt(jsonArrayAnswers.getString(i));
            // Questions # 1, 2, 20, 22, 34, 36
            if (i == 0 || i == 1 || i == 19 || i == 21 || i == 33 || i == 35) {
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
            if (i > 1 && i < 12) {
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
            if (i > 11 && i < 19) {
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
            if (i == 20 || i == 22 || i == 25 || i == 26 || i == 29) {
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
            if (i == 23 || i == 24 || i == 27 || i == 28 || i == 30) {
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
            if (i == 31 || i == 32 || i == 34) {
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
@Override
    public Integer countingBMI(JSONArray jsonArrayBMI) {
        int weight = 0;
        int height = 0;
        for (int i = 0; i < jsonArrayBMI.length(); i++) {
            if (jsonArrayBMI.getJSONObject(i).has("weight")) {
                weight = Integer.parseInt(jsonArrayBMI.getString(i));
            }
            if (jsonArrayBMI.getJSONObject(i).has("height")) {
                height = Integer.parseInt(jsonArrayBMI.getString(i));
            }
        }
        return weight / (height * height);
    }
}
