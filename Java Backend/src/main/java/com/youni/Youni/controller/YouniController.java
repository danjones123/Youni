package com.youni.Youni.controller;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.service.YouniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/youni")
public class YouniController {

  @Autowired
  private YouniService youniService;

  @GetMapping("/course")
  public List<UniversityCourse> getAllUniCourses() {

    return youniService.getAllUniCourse();
  }

  @GetMapping("/subject")
  public List<UniversitySubject> getAllUniSubject() {

    return youniService.getAllUniSubject();
  }

  @GetMapping("/university")
  public List<University> getAllUniversity() {

    return youniService.getAllUniversity();
  }

  @GetMapping("/alevel")
  public List<AlevelSubject> getAllAlevelSubject() {

    return youniService.getAllAlevelSubject();
  }

  @GetMapping("/compkey")
  public List<CombineUniversityCourseAlevelSubject> getAllCompKey() {
    return youniService.getAllCompKey();
  }

  @PostMapping("/subject")
  public ResponseEntity<?> addSubject(@RequestBody AddSubjectDto subjectDto) {

    try {
      return ResponseEntity.ok().body(youniService.addNewSubject(subjectDto));
    } catch (UniversityNotFoundException e) {
      return ResponseEntity.internalServerError().body(e);
    }

  }

}
