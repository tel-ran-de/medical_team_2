package com.example.health_checker.repository;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.enums.BodyPart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends CrudRepository<Story,Integer> {

    List<Story> findAllByBodyPart(BodyPart bodyPart);

    Optional<Story> findById(int s);
}
