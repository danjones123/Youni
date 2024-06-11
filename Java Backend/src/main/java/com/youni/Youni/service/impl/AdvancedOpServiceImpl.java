package com.youni.Youni.service.impl;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
import com.youni.Youni.entity.CombineUniversityCourseAlevelSubject;
import com.youni.Youni.entity.CombineUniversityUniversitySubject;
import com.youni.Youni.entity.University;
import com.youni.Youni.entity.UniversitySubject;
import com.youni.Youni.service.AdvancedOpService;
import com.youni.Youni.service.YouniCrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvancedOpServiceImpl implements AdvancedOpService {

  YouniCrudService youniCrudService;


  @Override
  public List<SuggestedSubjectAndUniversityDto> suggestCourseFromAlevels(ExpectedALevelGradesDto expectedALevelGradesDto) {

    //Ex Param = "Maths: ""
    //Read all from db and see if any have maths as required or recommended
    //Put those at the top of the list

    String[] alevelSubjects = expectedALevelGradesDto.getAlevelSubjectGrades().keySet().toArray(new String[0]);

    List<UniversitySubject> uniSubjectList = youniCrudService.getAllUniSubject();
    List<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList = youniCrudService.getAllUniCourseAlevelCompKey();

    ArrayList<SuggestedSubjectAndUniversityDto> outputList = new ArrayList<>();

    //TODO Split this list into one required Sub and one multi-list of the OR subjects
    ArrayList<UniversitySubject> requiredSubjects = new ArrayList<>();
    ArrayList<UniversitySubject> recommendedSubjects = new ArrayList<>();

    for (CombineUniversityCourseAlevelSubject uniSubject : combineUniversityCourseAlevelSubjectList) {
      if(alevelSubjects)
    }



    //For each subject should check which courses come up as highly related

    //if subject == recommended subject give it a point
    //Combine the points into a score to rank

    return null;
  }
}


//Update db so that the uni-course/a-level-subject has a weighting if the subject is REQUIRED, REQUIRED/MULTI, RECOMMENDED