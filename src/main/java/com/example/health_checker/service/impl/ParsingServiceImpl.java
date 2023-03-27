package com.example.health_checker.service.impl;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.service.ParsingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class ParsingServiceImpl implements ParsingService {
    private static final StoryTherapy storyTherapy = new StoryTherapy();
    private static final Therapy therapy = new Therapy();
    private static final Story story = new Story();


    @Override
    public void parseJSONObject(String request) {
        System.out.println("hackaton"+request);
        JSONObject jsonObjectMain = new JSONObject(request);
        System.out.println("jsonObjectMain  " + jsonObjectMain);
        JSONArray jsonArray = jsonObjectMain.getJSONArray("user_data");
        System.out.println(jsonArray+"hakaton");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.has("user_body_part")) {
                JSONArray jsonArray1 = jsonObject.getJSONArray("user_body_part");
                String bodyPart = jsonArray1.getString(0);
                System.out.println("ARRAY!!!!!!!!"+ jsonArray1.getString(0));
            }
            if (jsonObject.has("user_answers")) {
                JSONArray jsonArray2 = jsonObject.getJSONArray("user_answers");
                for (int j = 0; j < jsonArray2.length(); j++) {
                    Integer answer = jsonArray2.getInt(i);
                    System.out.println(j + "   " + answer);
                }
                getUserAnswers(jsonObject, jsonObject.getJSONArray("user_answers"));
            }
//            if (jsonObject.has("user_bmi")) {
////                JSONArray jsonArrayBMI = jsonObject.getJSONArray("user_bmi");
////                getUserBMI(jsonArrayBMI);
//            }
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

    private static void getUserBMI(JSONArray jsonArrayBMI) {
        getUserBMI(jsonArrayBMI);
    }


    @Override
    public JSONArray getUserAnswers(JSONObject jsonObjectAnswers, JSONArray jsonArrayAnswers) {
        log.info("accept Json with answers and return array as jsonArray");
        JSONArray AnswersArray = null;
        if (jsonObjectAnswers.has("user_answers")) {
            AnswersArray = jsonArrayAnswers;
        }
        return AnswersArray;
    }
}
