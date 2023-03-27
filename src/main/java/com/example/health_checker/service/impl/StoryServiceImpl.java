package com.example.health_checker.service.impl;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.exceptions.ErrorMessage;
import com.example.health_checker.exceptions.StoryNotExistedException;
import com.example.health_checker.repository.StoryRepository;
import com.example.health_checker.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

@Override
    public void chooseBodyPart(BodyPart bodyPart) {
    log.info("user choose bodyPart and we save it in db");
        Story story = Story.builder()
                .bodyPart(bodyPart).build();
        storyRepository.save(story);
    }
@Override
    public void describeProblem(String problem, int id) {
    log.info("user write description of problem an d we save it db");
        Story story = storyRepository.findById(id).orElseThrow(()->new StoryNotExistedException(ErrorMessage.STORY_NOT_EXISTS));
        story.setDescription(problem);
        storyRepository.save(story);
    }

}
