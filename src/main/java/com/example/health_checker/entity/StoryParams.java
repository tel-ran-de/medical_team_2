package com.example.health_checker.entity;

import com.example.health_checker.entity.converter.IndexTypeConverter;
import com.example.health_checker.entity.enums.IndexType;
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
@Table(name = "story_params")
public class StoryParams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private String value;

    @Enumerated(EnumType.STRING)
    @Convert(converter = IndexTypeConverter.class)
    @Column(name = "type")
    private IndexType type;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story_id;
}
