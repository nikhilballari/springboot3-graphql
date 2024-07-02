package com.dailypractise.demo.service;

import com.dailypractise.demo.Entity.Tutorial;
import com.dailypractise.demo.error.TutorialRecordException;
import com.dailypractise.demo.repository.TutorialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class TutorialServiceImpl implements TutorialService{

    private final TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Tutorial creteNewTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

    @Override
    public Tutorial findTutorial(Long id) throws TutorialRecordException {

        if(tutorialRepository.findById(id).isEmpty()) {
            throw new TutorialRecordException("Requested Tutorial record does not exist in DB");
        }
        log.info("Fetching Tutorial information for given id: {} from backend database", id);
        return tutorialRepository.findById(id).get();
    }

    @Override
    public Tutorial updateTutorial(Long id, Tutorial inputRecord) throws TutorialRecordException {

        Tutorial existingRecord = tutorialRepository.findById(id).orElse(null);
        if(Objects.isNull(existingRecord)) {
            throw new TutorialRecordException("Requested Tutorial record does not exist in DB");
        }

        if(Objects.nonNull(existingRecord.getTitle()) && !"".equalsIgnoreCase(inputRecord.getTitle())) {
            existingRecord.setTitle(inputRecord.getTitle());
        }
        if(Objects.nonNull(existingRecord.getDescription()) && !"".equalsIgnoreCase(inputRecord.getDescription())) {
            existingRecord.setDescription(inputRecord.getDescription());
        }
        existingRecord.setPublished(inputRecord.isPublished());

        return tutorialRepository.save(existingRecord);
    }

    @Override
    public String deleteTutorial(Long id) throws TutorialRecordException {
        if(tutorialRepository.findById(id).isEmpty()) {
            throw new TutorialRecordException("Requested Tutorial record does not exist in DB");
        }
        tutorialRepository.deleteById(id);
        return "Tutorial Record deleted successfully";
    }
}
