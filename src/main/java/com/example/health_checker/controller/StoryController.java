package com.example.health_checker.controller;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.service.StoryParamsService;
import com.example.health_checker.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoryController {

    private final StoryParamsService storyParamsService;
    private final StoryService storyService;

    @GetMapping("/welcome")
    public String writeWelcome() {
        return "Welcome";
    }

    @PostMapping("/pain-source")
    public String chooseBodyPart(@RequestParam BodyPart bodyPart) {
        storyService.chooseBodyPart(bodyPart);
        return "template_body";
    }

    @PostMapping("/quiz")
    public String createStory(@RequestBody StoryParams params) {
        storyParamsService.getMapOfAnswers(params);
        return "template_index_answers";
    }

    @PostMapping("/therapy")
    public String writeProblem(@RequestBody String problem, @RequestBody String id) {
        storyService.describeProblem(problem, id);
        return "describing_page";//add weight hight age
    }

    @GetMapping("/result")
    public String getIndexResult( @RequestParam(required = true) Integer height,
                                 @RequestParam(required = true) Integer weight,
                                 @RequestParam(required = true) Integer age,
                                 @RequestBody StoryParams params,
                                 @RequestParam(required = false) BodyPart bodyPart, Model model) {
        model.addAttribute("scores", storyParamsService.countingScores(params));
        model.addAttribute("BMI", storyParamsService.countingBMI(height,weight,age,params));
        model.addAttribute("therapy", storyService.getTherapyByParams(bodyPart));
       return "page_result";
    }

}
