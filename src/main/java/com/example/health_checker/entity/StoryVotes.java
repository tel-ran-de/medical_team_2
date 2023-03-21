package com.example.health_checker.entity;

import com.example.health_checker.entity.converter.VoteTypeConverter;
import com.example.health_checker.entity.enums.VoteType;
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
@Table(name = "story_votes")
public class StoryVotes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Story story_id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Convert(converter = VoteTypeConverter.class)
    private VoteType type;
}
