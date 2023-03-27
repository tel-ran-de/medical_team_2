package com.example.health_checker.service;

/**
 * the Interface describe adding comments
 */
public interface StoryCommentsService {
    /**
     * add comments to the therapy
     * @param problem
     * @param id
     */
    void describeProblem(String problem, int id);
}
