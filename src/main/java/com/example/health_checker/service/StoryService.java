package com.example.health_checker.service;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;

    public List<Story> getTherapyByParams(BodyPart bodyPart) {
        List<Story> stories;
        if (bodyPart != null) {
            stories = storyRepository.findAllByBodyPart(bodyPart);
        } else stories = (List<Story>) storyRepository.findAll();
        return stories;
    }

    public void chooseBodyPart(BodyPart bodyPart) {
        Story story = new Story();
        story.setBodyPart(bodyPart);
        storyRepository.save(story);
    }

    public void describeProblem(String problem, String id) {
        Story story = storyRepository.findById(id).orElseThrow();
        story.setDescription(problem);
    }

}
