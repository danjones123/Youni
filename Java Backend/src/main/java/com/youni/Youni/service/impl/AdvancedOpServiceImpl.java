package com.youni.Youni.service.impl;

import com.youni.Youni.dto.*;
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

    //TODO add second method for changing weighting based on grade
    // Need to update spreadsheet to have the min grades first (based on the min grade uni takes if not specified


    //Cache the results so that they can be used multiple times without being queried

    List<UniCourseAndRecommendedAlevels> uniCourseAndRecommendedAlevels = youniCrudService.getAllUniCourseAlevels();
    ArrayList<SuggestedSubjectAndUniversityDto> outputList = new ArrayList<>();

    for (UniCourseAndRecommendedAlevels uniCourseAndAlevel : uniCourseAndRecommendedAlevels) {
      SuggestedSubjectAndUniversityDto suggestedSubjectAndUniversityDto = new SuggestedSubjectAndUniversityDto();
      suggestedSubjectAndUniversityDto.setUniversityName(uniCourseAndAlevel.getUniversityName());
      suggestedSubjectAndUniversityDto.setSubjectName(uniCourseAndAlevel.getUniversitySubjectName());
      suggestedSubjectAndUniversityDto.setCourseName(uniCourseAndAlevel.getCourseName());

      if(uniCourseAndAlevel.getAlevelSubjects().isEmpty()) {
        suggestedSubjectAndUniversityDto.setRecommendedWeighting(0);
        outputList.add(suggestedSubjectAndUniversityDto);
        continue;
      }
      int weighting = 0;
      for(RecommendedAlevelsDto recommendedAlevelsDto : uniCourseAndAlevel.getAlevelSubjects()) {
        if(expectedALevelGradesDto.getAlevelSubjectGrades().containsKey(recommendedAlevelsDto.getAlevelName())) {
          if (recommendedAlevelsDto.getSubjectWeight().toString().equals("REQUIRED") ||
              recommendedAlevelsDto.getSubjectWeight().toString().equals("REQUIRED_MULTIPLE")) {
            weighting += 2;
          } else {
            weighting += 1;
          }
        }

      }

      suggestedSubjectAndUniversityDto.setRecommendedWeighting(weighting);

      outputList.add(suggestedSubjectAndUniversityDto);
    }
    outputList.sort(Comparator.comparingInt(SuggestedSubjectAndUniversityDto::getRecommendedWeighting).reversed());

    return outputList;
  }

  private List<UniCourseRequiredSubjects> combineUniCourseWithRequired(UniversityCourse universityCourse) {

//    List<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList = youniCrudService.getAllUniCourseAlevelCompKey();
    return null;
  }

}


//Update db so that the uni-course/a-level-subject has a weighting if the subject is REQUIRED, REQUIRED/MULTI, RECOMMENDED