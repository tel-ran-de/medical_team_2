package com.example.health_checker.entity;

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
@Table(name = "story_therapy")
public class StoryTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Story story_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Therapy therapy_id;

    @Column(name = "value")
    private Integer value;
}
