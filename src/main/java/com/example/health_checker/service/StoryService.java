package com.example.health_checker.service;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.exceptions.ErrorMessage;
import com.example.health_checker.exceptions.StoryNotExistedException;
import com.example.health_checker.repository.StoryRepository;
import com.example.health_checker.validation.PositiveInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;
    private final StoryParams storyParams;

    public List<Story> getTherapyByParams(Story story) {
        List<Story> stories;
        if (story.getBodyPart() != null ) {
            stories = storyRepository.findAllByBodyPart(story.getBodyPart());
        } else stories = (List<Story>) storyRepository.findAll();
        return stories;
    }

    public void chooseBodyPart(BodyPart bodyPart) {
        Story story = Story.builder()
                .bodyPart(bodyPart).build();
        storyRepository.save(story);
    }

    public void describeProblem(String problem, int id) {
        Story story = storyRepository.findById(id).orElseThrow(()->new StoryNotExistedException(ErrorMessage.STORY_NOT_EXISTS));
        story.setDescription(problem);//посчитать bmi
        storyRepository.save(story);
    }

}
