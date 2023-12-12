package com.youni.Youni.service.impl;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.dto.AddSubjectRankingDto;
import com.youni.Youni.dto.AddUniCourseDto;
import com.youni.Youni.dto.UniSubjectRankingResponseDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.entity.compositekeys.CompKeyUniUniSubject;
import com.youni.Youni.exception.DuplicateUniversitySubjectException;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;
import com.youni.Youni.repository.*;
import com.youni.Youni.service.YouniCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class YouniCrudServiceImpl implements YouniCrudService {

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


  //TODO update GET methods to return DTO
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
  public List<UniSubjectRankingResponseDto> getAllUniSubjectCompKey() {
    List<CombineUniversityUniversitySubject> compKeyUniUniSubjects = compKeyUniSubjectRepository.findAll();
    List<UniSubjectRankingResponseDto> uniSubjectRankingList = new ArrayList<>();
    for(CombineUniversityUniversitySubject combineUniversityUniversitySubject: compKeyUniUniSubjects) {
      UniSubjectRankingResponseDto uniSubjectRankingResponseDto = new UniSubjectRankingResponseDto(combineUniversityUniversitySubject.getUniversity().getUniversityName(),
          combineUniversityUniversitySubject.getUniversitySubject().getUniversitySubjectName(), combineUniversityUniversitySubject.getSubjectRanking());
      uniSubjectRankingList.add(uniSubjectRankingResponseDto);
    }

    return uniSubjectRankingList;
  }

  /**
   * Adds the ranking of a university subject in the composite table
   * @param subjectRankingDto Dto containing the uni, subject and ranking of the subject at the uni.
   * @return The updated list of all university rankings
   * @throws UniversityNotFoundException The university is not found
   * @throws UniversitySubjectNotFoundException The subject is not found
   */
  @Override
  public List<UniSubjectRankingResponseDto> addNewSubjectRanking(AddSubjectRankingDto subjectRankingDto) throws UniversityNotFoundException, UniversitySubjectNotFoundException{

    Optional<University> optionalUniversity = universityRepository.findByUniversityName(subjectRankingDto.getUniversityName());
    if (optionalUniversity.isEmpty()) {
      throw new UniversityNotFoundException(subjectRankingDto.getUniversityName());
    }
    University university = optionalUniversity.get();

    Optional<UniversitySubject> optionalUniversitySubject = subjectRepository.findByUniversitySubjectName(subjectRankingDto.getSubjectName());
    if (optionalUniversitySubject.isEmpty()) {
      throw new UniversitySubjectNotFoundException(subjectRankingDto.getSubjectName());
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
  public List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto) throws DuplicateUniversitySubjectException {

    if (subjectRepository.findByUniversitySubjectName(subjectDto.getSubjectName()).isPresent()) {
      throw new DuplicateUniversitySubjectException(subjectDto.getSubjectName());
    } else {
      //FIX accepts a null input and adds to db
      UniversitySubject subject = new UniversitySubject();
      subject.setUniversitySubjectName(subjectDto.getSubjectName());
      subjectRepository.save(subject);
      return getAllUniSubject();
    }
  }

  @Override
  public List<UniversityCourse> addNewUniCourse(AddUniCourseDto uniCourseDto) throws UniversitySubjectNotFoundException, UniversityNotFoundException {

    Optional<University> optionalUniversity = universityRepository.findByUniversityName(uniCourseDto.getUniversityName());
    if (optionalUniversity.isEmpty()) {
      throw new UniversityNotFoundException(uniCourseDto.getUniversityName());
    }
    University university = optionalUniversity.get();

    Optional<UniversitySubject> optionalUniversitySubject = subjectRepository.findByUniversitySubjectName(uniCourseDto.getUniversitySubjectName());
    if (optionalUniversitySubject.isEmpty()) {
      throw new UniversitySubjectNotFoundException(uniCourseDto.getUniversitySubjectName());
    }
    UniversitySubject universitySubject = optionalUniversitySubject.get();

    UniversityCourse universityCourse = new UniversityCourse(university, universitySubject, uniCourseDto.getCourseName(), uniCourseDto.getCourseLengthYears(),
        uniCourseDto.getDegreeType(), uniCourseDto.getUcasCode(), uniCourseDto.getRequiredGradesLettersUpper(), uniCourseDto.getRequiredGradesLettersLower(),
        uniCourseDto.getRequiredGradesIB(), uniCourseDto.getHasYearIndustry(), uniCourseDto.getHasFoundationYear());

    courseRepository.save(universityCourse);


    return getAllUniCourse();
  }




  //TODO Crud request for all of the tables
  // POST courses
  // need a bulk upload for the courses from a spreadsheet
  // POST combine Course/Alevel
  //TODO new service for the business logic separated from simple CRUD


}
