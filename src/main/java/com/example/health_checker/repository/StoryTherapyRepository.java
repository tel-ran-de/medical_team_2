package com.example.health_checker.repository;

import com.example.health_checker.entity.StoryTherapy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoryTherapyRepository extends CrudRepository<StoryTherapy,Integer> {

    List<StoryTherapy>findAll();

    Optional<StoryTherapy> findById(int s);
}
