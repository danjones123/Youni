package com.youni.Youni.service.impl;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
import com.youni.Youni.service.AdvancedOpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvancedOpServiceImpl implements AdvancedOpService {
  @Override
  public List<SuggestedSubjectAndUniversityDto> suggestCourseFromAlevels(ExpectedALevelGradesDto expectedALevelGradesDto) {


    //For each subject should check which courses come up as highly related

    //if subject == recommended subject give it a point
    //Combine the points into a score to rank

    return null;
  }
}


//Update db so that the uni-course/a-level-subject has a weighting if the subject is REQUIRED, REQUIRED/MULTI, RECOMMENDED