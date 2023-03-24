package com.example.health_checker.entity;

import com.example.health_checker.entity.converter.VoteTypeConverter;
import com.example.health_checker.entity.enums.VoteType;
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
@Table(name = "story_votes")
public class StoryVotes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story_id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Convert(converter = VoteTypeConverter.class)
    private VoteType type;
}
