package com.example.health_checker.creator;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.Therapy;
import com.example.health_checker.entity.enums.BodyPart;

public class EntityCreator {
    public static Story getStory1() {
        Story story1 = Story.builder()
                .id(1)
                .description("Headache around head and pressure on eye ")
                .bodyPart(BodyPart.HEAD)
                .healthScore(120)
                .bmi(35)
                .build();
        return story1;}
    public static Story getStory2() {
        Story story2 = Story.builder()
                .id(2)
                .description("Aching pain in the calf area")
                .bodyPart(BodyPart.LEG)
                .healthScore(130)
                .bmi(65)
                .build();
       return story2;}
       public static Therapy getTherapy1(){
        Therapy therapy1= Therapy.builder()
                .id(1)
                .name("Head treatment")
                .description("vinegar compresses")
                .build();
    return therapy1;}
    public static Therapy getTherapy2(){
        Therapy therapy2= Therapy.builder()
                .id(2)
                .name("Head treatment")
                .description("sleep more than 8 hours")
                .build();
        return therapy2;

    }
}
