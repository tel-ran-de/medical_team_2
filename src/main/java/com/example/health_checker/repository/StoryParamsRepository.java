package com.example.health_checker.repository;

import com.example.health_checker.entity.StoryParams;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoryParamsRepository extends CrudRepository<StoryParams, Integer> {

    Optional<StoryParams> findById(int s);
}
