package com.example.health_checker;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.repository.StoryRepository;
import com.example.health_checker.repository.StoryTherapyRepository;
import com.example.health_checker.repository.TherapyRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final StoryRepository storyRepository;
    private final TherapyRepository therapyRepository;
    private final StoryTherapyRepository storyTherapyRepository;

    @Override
    public void run(String... args) throws Exception {


        Story story1 = Story.builder()
                .id(1)
                .description("Headache around head and pressure on eye ")
                .bodyPart(BodyPart.HEAD)
                .healthScore(120)
                .bmi(35)
                .build();
        storyRepository.save(story1);
        Story story2 = Story.builder()
                .id(2)
                .description("Aching pain in the calf area")
                .bodyPart(BodyPart.LEG)
                .healthScore(130)
                .bmi(65)
                .build();
        storyRepository.save(story2);
        Story story3 = Story.builder()
                .id(3)
                .description("Shooting pain in the lower back when bending over and sitting down ")
                .bodyPart(BodyPart.BACK)
                .healthScore(120)
                .bmi(35)
                .build();
        storyRepository.save(story3);
        Story story4 = Story.builder()
                .id(1)
                .description("Headache in right side")
                .bodyPart(BodyPart.HEAD)
                .healthScore(150)
                .bmi(45)
                .build();
        storyRepository.save(story4);
        Therapy therapy1= Therapy.builder()
                .id(1)
                .name("Head treatment")
                .description("vinegar compresses")
                .build();
        therapyRepository.save(therapy1);
        Therapy therapy2= Therapy.builder()
                .id(2)
                .name("Head treatment")
                .description("sleep more than 8 hours")
                .build();
        therapyRepository.save(therapy2);
        Therapy therapy3= Therapy.builder()
                .id(3)
                .name("Leg treatment")
                .description("Go to the sauna and drink mineral water for 3 weeks")
                .build();
        therapyRepository.save(therapy3);
        Therapy therapy4= Therapy.builder()
                .id(4)
                .name("Leg")
                .description("sleep more than 8 hours")
                .build();
        therapyRepository.save(therapy4);

        StoryTherapy storyTherapy1 = StoryTherapy.builder()
                .id(1)
                .story(story1)
                .therapy_id(therapy1)
                .value(5)
                .build();
        storyTherapyRepository.save(storyTherapy1);
    }
}