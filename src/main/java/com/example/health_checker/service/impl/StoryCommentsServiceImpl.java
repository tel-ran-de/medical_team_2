package com.example.health_checker.service.impl;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryComments;
import com.example.health_checker.exceptions.ErrorMessage;
import com.example.health_checker.exceptions.StoryNotExistedException;
import com.example.health_checker.repository.StoryCommentsRepository;
import com.example.health_checker.service.StoryCommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoryCommentsServiceImpl implements StoryCommentsService {
    private final StoryCommentsRepository commentsRepository;
    @Override
    public void describeProblem(String comment, int id) {
        log.info("user write description of problem an d we save it db");
        var comments = commentsRepository.findById(id).orElseThrow();
        comments.setComment(comment);
        commentsRepository.save(comments);
    }
}
