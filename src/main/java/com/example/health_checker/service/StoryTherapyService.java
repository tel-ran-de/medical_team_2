package com.example.health_checker.service;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;

import java.util.List;

public interface StoryTherapyService {
    /**
     *
     * @param story
     * @return
     */
    List<StoryTherapy> getTherapyByParams(Story story);
}
