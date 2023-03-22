package com.example.health_checker.entity;

import com.example.health_checker.entity.converter.BodyPartConverter;
import com.example.health_checker.entity.enums.BodyPart;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity
@Table(name = "story")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    @Convert(converter = BodyPartConverter.class)
    private BodyPart bodyPart;

    @Column(name = "score")
    private Integer healthScore;

    @Column(name = "bmi")
    private Integer bmi;

}
