package com.example.health_checker.service;

/**
 * the interface describes work with JsonArray
 */
public interface CountingService {


    Integer countingScores(String request);

    Integer countingUserBMI(String request);
}
