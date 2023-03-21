package com.example.health_checker.repository;

import com.example.health_checker.entity.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, String> {

}
