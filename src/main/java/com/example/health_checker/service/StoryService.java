package com.example.health_checker.service;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.exceptions.ErrorMessage;
import com.example.health_checker.exceptions.StoryNotExistedException;
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
        Story story = Story.builder()
                .bodyPart(bodyPart).build();
        storyRepository.save(story);
    }

    public void describeProblem(String problem, int id) {
        Story story = storyRepository.findById(id).orElseThrow(()->new StoryNotExistedException(ErrorMessage.STORY_NOT_EXISTS));//CREATE PROBLEB IF NOT FIND
        story.setDescription(problem);
        storyRepository.save(story);
    }

}
