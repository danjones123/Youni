package com.youni.Youni.service.impl;

import com.youni.Youni.entity.*;
import com.youni.Youni.repository.*;
import com.youni.Youni.service.YouniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouniServiceImpl implements YouniService {

  @Autowired
  UniversityCourseRepository courseRepository;

  @Autowired
  UniversitySubjectRepository subjectRepository;

  @Autowired
  UniversityRepository universityRepository;

  @Autowired
  AlevelSubjectRepository alevelSubjectRepository;

  @Autowired
  CompKeyTest compKeyTest;


  @Override
  public List<UniversityCourse> getAllUniCourse() {
    return courseRepository.findAll();
  }

  @Override
  public List<UniversitySubject> getAllUniSubject() {
    return subjectRepository.findAll();
  }

  @Override
  public List<University> getAllUniversity() {
    return universityRepository.findAll();
  }

  @Override
  public List<AlevelSubject> getAllAlevelSubject() {
    return alevelSubjectRepository.findAll();
  }

  @Override
  public List<CombineUniversityCourseAlevelSubject> getAllCompKey() {
    return compKeyTest.findAll();
  }
}
