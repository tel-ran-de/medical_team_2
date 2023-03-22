package com.example.health_checker.repository;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.enums.BodyPart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoryRepository extends CrudRepository<Story, String> {

    List<Story> findAllByBodyPart(BodyPart bodyPart);
}
