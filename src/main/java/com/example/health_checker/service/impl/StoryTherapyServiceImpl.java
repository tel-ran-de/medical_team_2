package com.example.health_checker.service.impl;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.exceptions.ErrorMessage;
import com.example.health_checker.exceptions.NoAnyRecord;
import com.example.health_checker.repository.StoryTherapyRepository;
import com.example.health_checker.service.StoryTherapyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class StoryTherapyServiceImpl implements StoryTherapyService {

    private final StoryTherapyRepository storyTherapyRepository;

    @Override
    public List<StoryTherapy> getTherapyByParams(Story story) {
        log.info("according parameters getting list of similar diseases");
        var therapy = storyTherapyRepository.findAll();
        if (therapy.isEmpty()){
            throw new NoAnyRecord(ErrorMessage.NO_RECORDS);
        }
        return therapy.stream().filter(st->st.getStory().getBodyPart().equals(story.getBodyPart())).toList();
        }
    }


