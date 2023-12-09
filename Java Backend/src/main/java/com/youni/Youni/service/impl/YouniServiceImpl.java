package com.youni.Youni.service.impl;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.dto.AddSubjectRankingDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.entity.compositekeys.CompKeyUniUniSubject;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;
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
  public List<CombineUniversityCourseAlevelSubject> getAllUniCourseAlevelCompKey() {
    return compKeyUniAlevelRepository.findAll();
  }

  @Override
  public List<CombineUniversityUniversitySubject> getAllUniSubjectCompKey() {
    //TODO Update the return Dto to only have the uni/subject name and rankings
    return compKeyUniSubjectRepository.findAll();
  }

  /**
   * Adds the ranking of a university subject
   * @param subjectRankingDto
   * @return
   * @throws UniversityNotFoundException
   */
  @Override
  public List<CombineUniversityUniversitySubject> addNewSubjectRanking(AddSubjectRankingDto subjectRankingDto) throws UniversityNotFoundException, UniversitySubjectNotFoundException{

    Optional<University> optionalUniversity = universityRepository.findByUniversityName(subjectRankingDto.getUniversityName());
    if (optionalUniversity.isEmpty()) {
      throw new UniversityNotFoundException("University " + subjectRankingDto.getUniversityName() + " not found");
    }
    University university = optionalUniversity.get();

    Optional<UniversitySubject> optionalUniversitySubject = subjectRepository.findByUniversitySubjectName(subjectRankingDto.getSubjectName());
    if (optionalUniversitySubject.isEmpty()) {
      throw new UniversitySubjectNotFoundException("Subject " + subjectRankingDto.getSubjectName() + " not found");
    }
    UniversitySubject universitySubject = optionalUniversitySubject.get();

    CombineUniversityUniversitySubject combineUniversityUniversitySubject = new CombineUniversityUniversitySubject();
    combineUniversityUniversitySubject.setUniversity(university);
    combineUniversityUniversitySubject.setUniversitySubject(universitySubject);
    combineUniversityUniversitySubject.setSubjectRanking(subjectRankingDto.getSubjectRanking());
    CompKeyUniUniSubject compKeyUniUniSubject = new CompKeyUniUniSubject();
    compKeyUniUniSubject.setUniversitySubjectId(universitySubject.getUniversitySubjectId());
    compKeyUniUniSubject.setUniversityId(university.getUniversityId());
    combineUniversityUniversitySubject.setCompKeyUniUniSubject(compKeyUniUniSubject);
    compKeyUniSubjectRepository.save(combineUniversityUniversitySubject);



    return getAllUniSubjectCompKey();
  }


  @Override
  public List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto) {

//    UniversitySubject subject = new UniversitySubject();
//    subject.setUniversitySubjectName(subjectDto.getSubjectName());
//    UniversitySubject subject2 = subjectRepository.save(subject);
//
//    CombineUniversityUniversitySubject combineUniversityUniversitySubject = new CombineUniversityUniversitySubject();
//    combineUniversityUniversitySubject.setUniversity(university);
//    combineUniversityUniversitySubject.setUniversitySubject(subject2);
//    combineUniversityUniversitySubject.setSubjectRanking(subjectRankingDto.getSubjectRanking());
//    CompKeyUniUniSubject compKeyUniUniSubject = new CompKeyUniUniSubject();
//    compKeyUniUniSubject.setUniversitySubjectId(subject2.getUniversitySubjectId());
//    compKeyUniUniSubject.setUniversityId(university.getUniversityId());
//    combineUniversityUniversitySubject.setCompKeyUniUniSubject(compKeyUniUniSubject);
//    compKeyUniSubjectRepository.save(combineUniversityUniversitySubject);

    //! Poss change db to have course be directly under university and subject as a separate side table

    return getAllUniSubject();
  }


  //TODO Crud request for all of the tables
}
