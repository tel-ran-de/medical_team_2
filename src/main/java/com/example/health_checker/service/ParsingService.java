package com.example.health_checker.service;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * the interface describes parsing JsonData
 */
public interface ParsingService {


    void parseJSONObject(String request);

    JSONArray getUserAnswers(JSONObject jsonObjectAnswers, JSONArray jsonArrayAnswers);
}
