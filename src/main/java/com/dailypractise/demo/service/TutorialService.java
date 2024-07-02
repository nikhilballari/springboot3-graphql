package com.dailypractise.demo.service;

import com.dailypractise.demo.Entity.Tutorial;
import com.dailypractise.demo.error.TutorialRecordException;

import java.util.List;

public interface TutorialService {
    Tutorial creteNewTutorial(Tutorial tutorial);

    List<Tutorial> getAllTutorials();

    Tutorial findTutorial(Long id) throws TutorialRecordException;

    Tutorial updateTutorial(Long id, Tutorial inputRecord) throws TutorialRecordException;

    String deleteTutorial(Long id) throws TutorialRecordException;
}
