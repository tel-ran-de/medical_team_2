package com.example.health_checker.controller;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.service.CountingService;
import com.example.health_checker.service.ParsingService;
import com.example.health_checker.service.StoryService;
import com.example.health_checker.service.StoryTherapyService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class StoryController {

    private final CountingService countingService;
    private final StoryService storyService;
    private final ParsingService parsingService;
    private final StoryTherapyService storyTherapyService;

    @PostMapping("/pain-source")
    @ResponseStatus(OK)
    public void chooseBodyPart(@RequestBody BodyPart bodyPart) {
        storyService.chooseBodyPart(bodyPart);
    }

    @GetMapping("/story")
    @ResponseStatus(OK)
    public void createStory(@RequestBody String jsonArray) {
        parsingService.parseJSONObject(jsonArray);
    }
    @GetMapping("/therapy")
    @ResponseStatus(OK)
    public List<StoryTherapy> getTherapy(Story story){
        return  storyTherapyService.getTherapyByParams(story);
    }
    @PostMapping("/problem")
    public void writeProblem(@RequestParam String problem,
                             @RequestParam Integer id) {
        storyService.describeProblem(problem, id);
    }

    @PostMapping("/#/tips")
    @ResponseStatus(OK)
    public String getIndexResult(@RequestBody String request,
                                 Model model) {
        parsingService.parseJSONObject(request);
        model.addAttribute("scores", countingService.countingScores(request));
        return "/#/tips";
    }
}
