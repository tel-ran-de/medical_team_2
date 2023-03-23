package com.example.health_checker.service.impl;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ParsingServiceImpl implements ParsingService {
    private static final StoryTherapy storyTherapy = new StoryTherapy();
    private static final Therapy therapy = new Therapy();
    private static final Story story = new Story();

    @Override
    public void parseJSONArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.has("user_body_part")) {
                story.setBodyPart(jsonObject.getEnum(BodyPart.class, "user_body_part"));
            }
            getUserAnswers(jsonObject, jsonObject.getJSONArray("user_answers"));
            getUserBMI(jsonObject, (jsonObject.getJSONArray("user_bmi")));
            if (jsonObject.has("user_therapy")) {
                JSONArray therapyArray = jsonObject.getJSONArray("user_therapy");
                for (int j = 0; j < therapyArray.length(); j++) {
                    JSONObject therapyObject = therapyArray.getJSONObject(j);
                    therapy.setName(therapyObject.getString("therapy"));
                    storyTherapy.setValue(Integer.valueOf(therapyObject.getString("reaction")));
                }
            }
            if (jsonObject.has("user_description")) {
                story.setDescription(jsonObject.getString("user_description"));
            }
        }
    }

    @Override
    public JSONArray getUserBMI(JSONObject jsonObjectBMI, JSONArray jsonArrayBMI) {
        JSONArray bmiArray = null;
        if (jsonObjectBMI.has("weight")) {
            bmiArray = jsonArrayBMI;
        }
        return bmiArray;
    }

    @Override
    public JSONArray getUserAnswers(JSONObject jsonObjectAnswers, JSONArray jsonArrayAnswers) {
        JSONArray AnswersArray = null;
        if (jsonObjectAnswers.has("user_answers")) {
            AnswersArray = jsonArrayAnswers;
        }
        return AnswersArray;
    }
}
