package com.youni.Youni.service;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvancedOpService {
  List<SuggestedSubjectAndUniversityDto> suggestCourseFromAlevels(ExpectedALevelGradesDto expectedALevelGradesDto);
}
