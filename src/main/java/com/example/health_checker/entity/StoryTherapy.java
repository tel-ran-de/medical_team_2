package com.example.health_checker.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity
@Table(name = "story_therapy")
public class StoryTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    @ManyToOne
    @JoinColumn(name = "therapy_id")
    private Therapy therapy_id;

    @Column(name = "value")
    private Integer value;
}
