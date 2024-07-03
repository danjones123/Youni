package com.youni.Youni.service.impl;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
import com.youni.Youni.dto.UniCourseRequiredSubjects;
import com.youni.Youni.entity.*;
import com.youni.Youni.service.AdvancedOpService;
import com.youni.Youni.service.YouniCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AdvancedOpServiceImpl implements AdvancedOpService {

  @Autowired
  YouniCrudService youniCrudService;


  @Override
  public List<SuggestedSubjectAndUniversityDto> suggestCourseFromAlevels(ExpectedALevelGradesDto expectedALevelGradesDto) {

    //TODO Update to combine the expected grade and courses into combined object and then check. Means no duplicates and more accurate weighting (eg higher weighting if multiple common subjects)
    //Goal is to receive A-level subjects, and return which university courses best match with those
    //Higher weighting for more courses in common
    //Get all of the uni courses and combine into object with their required A-levels
    //Go through the A-Levels that student uploaded and score the subject output for any subjects in common
    //Courses that don't have any requirements also appear
    //Courses that have requirements not uploaded should not appear


    //Cache the results so that they can be used multiple times without being queried





    //Takes a-level subjects from user and converts to array
    String[] alevelSubjects = expectedALevelGradesDto.getAlevelSubjectGrades().keySet().toArray(new String[0]);

    List<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList = youniCrudService.getAllUniCourseAlevelCompKey();
    ArrayList<SuggestedSubjectAndUniversityDto> outputList = new ArrayList<>();
    List<CombineUniversityCourseAlevelSubject> overlapSubjects = new ArrayList<>();

    //Go through the list of subjects that have recommended subjects and checks if they contain the subjects that the student is taking
    for (CombineUniversityCourseAlevelSubject combineUniversityCourseAlevelSubject : combineUniversityCourseAlevelSubjectList) {
      if(!expectedALevelGradesDto.getAlevelSubjectGrades().containsKey(combineUniversityCourseAlevelSubject.getAlevelSubject().getAlevelSubjectName())) {
        SuggestedSubjectAndUniversityDto suggestedSubjectAndUniversityDto = new SuggestedSubjectAndUniversityDto();
        suggestedSubjectAndUniversityDto.setSubjectName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversityCourseName());
        suggestedSubjectAndUniversityDto.setUniversityName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversity().getUniversityName());
        suggestedSubjectAndUniversityDto.setRecommendedWeighting(4);
        outputList.add(suggestedSubjectAndUniversityDto);
      } else {
        overlapSubjects.add(combineUniversityCourseAlevelSubject);
      }
    }

    for(CombineUniversityCourseAlevelSubject combineUniversityCourseAlevelSubject : overlapSubjects) {

      for (String subject : alevelSubjects) {

        SuggestedSubjectAndUniversityDto suggestedSubjectAndUniversityDto = new SuggestedSubjectAndUniversityDto();
        if (!subject.equals(combineUniversityCourseAlevelSubject.getAlevelSubject().getAlevelSubjectName())) {
        continue;
        }

        if (combineUniversityCourseAlevelSubject.getRequiredWeight().toString().equals("REQUIRED") ||
            combineUniversityCourseAlevelSubject.getRequiredWeight().toString().equals("REQUIRED_MULTIPLE")) {

          suggestedSubjectAndUniversityDto.setRecommendedWeighting(1);
        } else {
          //This should not be hit but is added incase there is issue with data
          //Possibly would be better to add the "Recommended" subjects as the else statement?
          suggestedSubjectAndUniversityDto.setRecommendedWeighting(2);
        }
        suggestedSubjectAndUniversityDto.setSubjectName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversityCourseName());
        suggestedSubjectAndUniversityDto.setUniversityName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversity().getUniversityName());

        //If the alevel subjects is recommended or required for a uni course, adds that course to the output list with a weighting

        outputList.add(suggestedSubjectAndUniversityDto);
      }
    }


    outputList.sort(Comparator.comparingInt(SuggestedSubjectAndUniversityDto::getRecommendedWeighting));





    //For each subject should check which courses come up as highly related

    //if subject == recommended subject give it a point
    //Combine the points into a score to rank

    return outputList;
  }

  private List<UniCourseRequiredSubjects> combineUniCourseWithRequired(UniversityCourse universityCourse) {

//    List<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList = youniCrudService.getAllUniCourseAlevelCompKey();
    return null;
  }

}


//Update db so that the uni-course/a-level-subject has a weighting if the subject is REQUIRED, REQUIRED/MULTI, RECOMMENDED