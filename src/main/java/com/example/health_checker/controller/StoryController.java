package com.example.health_checker.controller;

import com.example.health_checker.entity.Story;
import com.example.health_checker.entity.StoryParams;
import com.example.health_checker.entity.StoryTherapy;
import com.example.health_checker.entity.enums.BodyPart;
import com.example.health_checker.service.impl.StoryParamsServiceImpl;
import com.example.health_checker.service.impl.StoryServiceImpl;
import com.example.health_checker.service.impl.StoryTherapyServiceImpl;
import com.example.health_checker.validation.PositiveInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class StoryController {

    private final StoryParamsServiceImpl storyParamsServiceImpl;
    private final StoryServiceImpl storyServiceImpl;
    private final StoryTherapyServiceImpl therapyService;

    /**
     *
     * @param bodyPart
     */
    @PostMapping("/pain-source")
    public void chooseBodyPart(@RequestBody BodyPart bodyPart) {
        storyServiceImpl.chooseBodyPart(bodyPart);
    }

    /**
     *
     * @param params
     */
    @PostMapping("/quiz")
    public void createStory(@RequestBody StoryParams params) {
        storyParamsServiceImpl.getMapOfAnswers(params);
    }

    /**
     *
     * @param problem
     * @param height
     * @param weight
     * @param age
     * @param id
     */
    @PostMapping("/problem")
    public void writeProblem(@RequestParam String problem,
                               @RequestParam(required = true) @PositiveInteger Integer height,
                               @RequestParam(required = true) @PositiveInteger Integer weight,
                               @RequestParam(required = true) @PositiveInteger Integer age,
                               @RequestParam int id) {
        storyServiceImpl.describeProblem(problem, id);
    }

    /**
     *
     * @param height
     * @param weight
     * @param age
     * @param params
     * @param bodyPart
     * @param model
     * @return
     */
    @GetMapping("/result")
    public String getIndexResult(@RequestParam(required = true) @PositiveInteger Integer height,//SAVE TIO DB AND
                                 @RequestParam(required = true) @PositiveInteger Integer weight,
                                 @RequestParam(required = true) @PositiveInteger Integer age,
                                 @RequestBody StoryParams params,
                                 @RequestParam(required = false) BodyPart bodyPart, Model model) {
       // model.addAttribute("scores", storyParamsService.countingScores(params));
     //   model.addAttribute("BMI", storyParamsService.countingBMI(age,params));
       // model.addAttribute("therapy", storyService.getTherapyByParams(bodyPart));
       return "page_result";
    }

    /**
     *
     * @param story
     * @return
     */
    @GetMapping("/therapy")
    public List<StoryTherapy> getTherapy(Story story){
      return  therapyService.getTherapyByParams(story);
    }
}
