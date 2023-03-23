package com.example.health_checker.controller;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.service.CountingService;
import com.example.health_checker.service.ParsingService;
import com.example.health_checker.service.StoryService;
import com.example.health_checker.service.StoryTherapyService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class StoryController {

    private final CountingService countingService;
    private final StoryService storyService;
    private final ParsingService parsingService;
    private final StoryTherapyService storyTherapyService;

    @PostMapping("/pain-source")
    @ResponseStatus(OK)
    public void chooseBodyPart(@RequestParam BodyPart bodyPart) {
        storyService.chooseBodyPart(bodyPart);
    }

    @GetMapping("/story")
    @ResponseStatus(OK)
    public void createStory(@RequestBody JSONArray jsonArray) {
        parsingService.parseJSONArray(jsonArray);
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

    @GetMapping("/result")
    @ResponseStatus(OK)
    public String getIndexResult(@RequestBody JSONArray jsonArray,
                                 @RequestBody(required = false) Story story,
                                 Model model) {
        model.addAttribute("scores", countingService.countingScores(jsonArray));
        model.addAttribute("BMI", countingService.countingBMI(jsonArray));
        model.addAttribute("therapy", storyTherapyService.getTherapyByParams(story));
        return "page_result";
    }
}
