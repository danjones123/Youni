package com.youni.Youni.service.impl;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
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

    //Takes a-level subjects and converts to array
    String[] alevelSubjects = expectedALevelGradesDto.getAlevelSubjectGrades().keySet().toArray(new String[0]);

    List<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList = youniCrudService.getAllUniCourseAlevelCompKey();
    ArrayList<SuggestedSubjectAndUniversityDto> outputList = new ArrayList<>();

    //Go through the list of subjects that have recommended subjects and checks if they contain the subjects that the student is taking
    for (CombineUniversityCourseAlevelSubject combineUniversityCourseAlevelSubject : combineUniversityCourseAlevelSubjectList) {
      for (String subject : alevelSubjects) {

        SuggestedSubjectAndUniversityDto suggestedSubjectAndUniversityDto = new SuggestedSubjectAndUniversityDto();
        suggestedSubjectAndUniversityDto.setSubjectName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversityCourseName());
        suggestedSubjectAndUniversityDto.setUniversityName(combineUniversityCourseAlevelSubject.getUniversityCourse().getUniversity().getUniversityName());

        //If the alevel subjects is recommended or required for a uni course, adds that course to the output list with a weighting
        if (subject.equals(combineUniversityCourseAlevelSubject.getAlevelSubject().getAlevelSubjectName())) {
          if (combineUniversityCourseAlevelSubject.getRequiredWeight().toString().equals("REQUIRED") ||
              combineUniversityCourseAlevelSubject.getRequiredWeight().toString().equals("REQUIRED_MULTIPLE")) {

            suggestedSubjectAndUniversityDto.setRecommendedWeighting(1);
          } else if ((combineUniversityCourseAlevelSubject.getRequiredWeight().toString().equals("RECOMMENDED"))) {
            suggestedSubjectAndUniversityDto.setRecommendedWeighting(2);
          } else {
            //This should not be hit but is added incase there is issue with data
            //Possibly would be better to add the "Recommended" subjects as the else statement?
            suggestedSubjectAndUniversityDto.setRecommendedWeighting(4);
          }
        }else {
          suggestedSubjectAndUniversityDto.setRecommendedWeighting(4);
        }

        outputList.add(suggestedSubjectAndUniversityDto);
      }
    }

    outputList.sort(Comparator.comparingInt(SuggestedSubjectAndUniversityDto::getRecommendedWeighting));





    //For each subject should check which courses come up as highly related

    //if subject == recommended subject give it a point
    //Combine the points into a score to rank

    return outputList;
  }
}


//Update db so that the uni-course/a-level-subject has a weighting if the subject is REQUIRED, REQUIRED/MULTI, RECOMMENDED