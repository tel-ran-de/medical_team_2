package com.example.health_checker.service;

import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.repository.StoryParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class StoryParamsService {

    private final StoryParamsRepository paramsRepository;

    private double PF_sum, PF, PF_Z, RP_sum, RP, RP_Z, BP, BP_sum;

    private String answer;

    @Autowired
    public StoryParamsService(StoryParamsRepository paramsRepository) {
        this.paramsRepository = paramsRepository;
    }

    public HashMap<Integer, Integer> getMapOfAnswers(StoryParams params) {
        Integer value = Integer.valueOf(params.getValue());
        Integer key = params.getId();
        HashMap<Integer, Integer> answers = new HashMap<>();
        answers.put(key, value);
        return answers;
    }

    public Double countingScoresPhysicalFunctioning(StoryParams params) {
        HashMap<Integer, Integer> answers = getMapOfAnswers(params);
        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            if (entry.getKey() > 1 && entry.getKey() < 12) {
                Integer score = entry.getValue();
                switch (score) {
                    case 1 : score = 0;
                        break;
                    case 2 : score = 50;
                        break;
                    case 3 : score = 100;
                        break;
                }
                PF_sum = PF_sum + score;
            }
            if (entry.getKey() > 11 && entry.getKey() < 16) {
                Integer score = entry.getValue();
                switch (score) {
                    case 1 : score = 0;
                        break;
                    case 2 : score = 50;
                        break;
                    case 3 : score = 100;
                        break;
                }
                RP_sum = RP_sum + score;
            }
            if (entry.getKey() == 20 || entry.getKey() == 21) {
                Double score = Double.valueOf(entry.getValue());
                if (score == 1) {
                    score = 6.0;
                } else if (score == 2) {
                    score = 5.4;
                } else if (score == 3) {
                    score = 4.2;
                } else if (score == 4) {
                    score = 3.1;
                } else if (score == 5) {
                    score = 2.2;
                } else if (score == 6) {
                    score = 1.0;
                }
                BP_sum = BP_sum + score;
            }


        }


        }
        PF = ((PF_sum - 10) / 20) * 100;
        PF_Z = (PF - 84.52404) / 22.89490;
    BP = [ ((BP7” + BP8”) – 2 )/ 10 ] * 100

    }


        RP = ((RP_sum - 4) / 4) * 100;
        RP_Z = (RP - 81.19907) / 33.797290;


    }


}
