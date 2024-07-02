package com.dailypractise.demo.controller;

import com.dailypractise.demo.Entity.Tutorial;
import com.dailypractise.demo.error.TutorialRecordException;
import com.dailypractise.demo.service.TutorialService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    private final TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping
    public List<Tutorial> getAllTutorials() {
        return tutorialService.getAllTutorials();
    }

    @Cacheable(value = "tutorialCache")
    @GetMapping("/{id}")
    public Tutorial findTutorial(@PathVariable("id") Long id) throws TutorialRecordException {
        return tutorialService.findTutorial(id);
    }

    @PostMapping
    public Tutorial crateNewTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.creteNewTutorial(tutorial);
    }

    @PutMapping("/{id}")
    @CachePut(value = "tutorialCache")
    public Tutorial updateTutorial(@PathVariable("id") Long id, @RequestBody Tutorial inputRecord) throws TutorialRecordException {
        return tutorialService.updateTutorial(id, inputRecord);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "tutorialCache")
    public String deleteTutorial(@PathVariable("id") Long id) throws TutorialRecordException {
        return tutorialService.deleteTutorial(id);
    }

}
