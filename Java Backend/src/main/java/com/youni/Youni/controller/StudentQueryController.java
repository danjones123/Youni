package com.youni.Youni.controller;

import com.youni.Youni.dto.ExpectedALevelGradesDto;
import com.youni.Youni.dto.SuggestedSubjectAndUniversityDto;
import com.youni.Youni.service.AdvancedOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentQueryController {

  @Autowired
  private AdvancedOpService advancedOpService;

  @PostMapping("/suggestedCourse")
  public ResponseEntity<?> suggestedCourseFromAlevels(@RequestBody ExpectedALevelGradesDto expectedALevelGradesDto) {
    List<SuggestedSubjectAndUniversityDto> suggestedSubjectAndUniversityDtoList = advancedOpService.suggestCourseFromAlevels(expectedALevelGradesDto);
    return ResponseEntity.ok().body(suggestedSubjectAndUniversityDtoList);
  }
}
