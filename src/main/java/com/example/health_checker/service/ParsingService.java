package com.example.health_checker.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


public interface ParsingService {
    void parseJSONArray(JSONArray jsonArray);

    JSONArray getUserBMI(JSONObject jsonObjectBMI, JSONArray jsonArrayBMI);

    JSONArray getUserAnswers(JSONObject jsonObjectAnswers, JSONArray jsonArrayAnswers);
}
