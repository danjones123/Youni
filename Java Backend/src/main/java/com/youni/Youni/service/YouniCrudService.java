package com.youni.Youni.service;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.dto.AddSubjectRankingDto;
import com.youni.Youni.dto.AddUniCourseDto;
import com.youni.Youni.dto.UniSubjectRankingResponseDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.exception.DuplicateUniversitySubjectException;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;

import java.util.List;

public interface YouniCrudService {


  List<UniversityCourse> getAllUniCourse();

  List<UniversitySubject> getAllUniSubject();

  List<University> getAllUniversity();

  List<AlevelSubject> getAllAlevelSubject();

  List<CombineUniversityCourseAlevelSubject> getAllUniCourseAlevelCompKey();

  List<UniSubjectRankingResponseDto> addNewSubjectRanking(AddSubjectRankingDto subjectRankingDto) throws UniversityNotFoundException, UniversitySubjectNotFoundException;

  List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto) throws DuplicateUniversitySubjectException;

  List<UniSubjectRankingResponseDto> getAllUniSubjectCompKey();

  List<UniversityCourse> addNewUniCourse(AddUniCourseDto uniCourseDto) throws UniversitySubjectNotFoundException, UniversityNotFoundException;
}
