package com.example.health_checker.controller;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.repository.StoryRepository;
import com.example.health_checker.service.StoryParamsService;
import com.example.health_checker.service.StoryService;
import com.example.health_checker.validation.PositiveInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class StoryController {

    private final StoryParamsService storyParamsService;
    private final StoryService storyService;
    private final StoryRepository storyRepository;

    @PostMapping("/pain-source")
    public void chooseBodyPart(@RequestBody BodyPart bodyPart) {
        storyService.chooseBodyPart(bodyPart);
    }

    @PostMapping("/quiz")
    public void createStory(@RequestBody StoryParams params) {
        storyParamsService.getMapOfAnswers(params);
    }

    @PostMapping("/problem")
    public void writeProblem(@RequestParam String problem,//как обрабатывать эти параметры
                               @RequestParam(required = true) @PositiveInteger Integer height,
                               @RequestParam(required = true) @PositiveInteger Integer weight,
                               @RequestParam(required = true) @PositiveInteger Integer age,
                               @RequestParam int id) {
        storyService.describeProblem(problem, id);

    }

    @GetMapping("/result")
    public String getIndexResult(@RequestParam(required = true) @PositiveInteger Integer height,//SAVE TIO DB AND
                                 @RequestParam(required = true) @PositiveInteger Integer weight,
                                 @RequestParam(required = true) @PositiveInteger Integer age,
                                 @RequestBody StoryParams params,
                                 @RequestParam(required = false) BodyPart bodyPart, Model model) {
       // model.addAttribute("scores", storyParamsService.countingScores(params));
        model.addAttribute("BMI", storyParamsService.countingBMI(height,weight,age,params));
       // model.addAttribute("therapy", storyService.getTherapyByParams(bodyPart));
       return "page_result";
    }

    @GetMapping("/therapy")
    public void getTherapy(Story story){
        storyService.getTherapyByParams(story);

    }
}
