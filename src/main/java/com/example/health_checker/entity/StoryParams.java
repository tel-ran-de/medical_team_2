package com.example.health_checker.entity;

import com.example.health_checker.entity.converter.BodyPartConverter;
import com.example.health_checker.entity.enums.IndexType;
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
@Table(name = "story_params")
public class StoryParams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")//json
    private String value;

    @Enumerated(EnumType.STRING)
    @Convert(converter = IndexType.class)
    @Column(name = "type")//FK
    private IndexType type;

    @ManyToOne
    @JoinColumn(name = "id")
    private Story story_id;
}
