package com.youni.Youni.service.impl;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.entity.compositekeys.CompKeyUniUniSubject;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.repository.*;
import com.youni.Youni.service.YouniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  CompKeyUniAlevelRepository compKeyUniAlevelRepository;

  @Autowired
  CompKeyUniSubjectRepository compKeyUniSubjectRepository;


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
    return compKeyUniAlevelRepository.findAll();
  }

  @Override
  public List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto) throws UniversityNotFoundException{

    Optional<University> optionalUniversity = universityRepository.findByUniversityName(subjectDto.getUniversityName());
    if (optionalUniversity.isEmpty()) {
      throw new UniversityNotFoundException("University not found");
    }
    University university = optionalUniversity.get();
    UniversitySubject subject = new UniversitySubject();
    subject.setUniversitySubjectName(subjectDto.getSubjectName());
    UniversitySubject subject2 = subjectRepository.save(subject);
    CombineUniversityUniversitySubject combineUniversityUniversitySubject = new CombineUniversityUniversitySubject();
    combineUniversityUniversitySubject.setUniversity(university);
    combineUniversityUniversitySubject.setUniversitySubject(subject2);
    combineUniversityUniversitySubject.setSubjectRanking(subjectDto.getSubjectRanking());
    CompKeyUniUniSubject compKeyUniUniSubject = new CompKeyUniUniSubject();
    compKeyUniUniSubject.setUniversitySubjectId(subject2.getUniversitySubjectId());
    compKeyUniUniSubject.setUniversityId(university.getUniversityId());
    combineUniversityUniversitySubject.setCompKeyUniUniSubject(compKeyUniUniSubject);
    compKeyUniSubjectRepository.save(combineUniversityUniversitySubject);

    //! Poss change db to have course be directly under university and subject as a separate side table

    return getAllUniSubject();
  }


}
