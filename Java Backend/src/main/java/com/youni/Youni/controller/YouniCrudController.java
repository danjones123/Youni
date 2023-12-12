package com.youni.Youni.controller;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.dto.AddSubjectRankingDto;
import com.youni.Youni.dto.AddUniCourseDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.exception.DuplicateUniversitySubjectException;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;
import com.youni.Youni.service.YouniCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/younicrud")
public class YouniCrudController {
//TODO rename to crud controller
  @Autowired
  private YouniCrudService youniCrudService;

  @GetMapping("/course")
  public List<UniversityCourse> getAllUniCourses() {

    return youniCrudService.getAllUniCourse();
  }

  @GetMapping("/subject")
  public List<UniversitySubject> getAllUniSubject() {

    return youniCrudService.getAllUniSubject();
  }

  @GetMapping("/university")
  public List<University> getAllUniversity() {

    return youniCrudService.getAllUniversity();
  }

  @GetMapping("/alevel")
  public List<AlevelSubject> getAllAlevelSubject() {

    return youniCrudService.getAllAlevelSubject();
  }

  @GetMapping("/compkey")
  public List<CombineUniversityCourseAlevelSubject> getAllCompKey() {
    return youniCrudService.getAllUniCourseAlevelCompKey();
  }

  @PostMapping("/subjectRank")
  public ResponseEntity<?> addSubject(@RequestBody AddSubjectRankingDto subjectRankingDto) {

    try {
      return ResponseEntity.ok().body(youniCrudService.addNewSubjectRanking(subjectRankingDto));
    } catch (UniversityNotFoundException | UniversitySubjectNotFoundException e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }

  }

  @PostMapping("/subject")
  public ResponseEntity<?> addSubject(@RequestBody AddSubjectDto subjectDto) {

    try {
      return ResponseEntity.ok().body(youniCrudService.addNewSubject(subjectDto));
    } catch (DuplicateUniversitySubjectException e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }

  }

  @PostMapping("/course")
  public ResponseEntity<?> addUniversityCourse(@RequestBody AddUniCourseDto uniCourseDto) throws UniversitySubjectNotFoundException, UniversityNotFoundException {
    try {
      return ResponseEntity.ok().body(youniCrudService.addNewUniCourse(uniCourseDto));
    } catch (UniversityNotFoundException | UniversitySubjectNotFoundException e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
}
