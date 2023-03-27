package com.example.health_checker.repository;

import com.example.health_checker.entity.Therapy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapyRepository extends CrudRepository<Therapy,Integer> {
}
