package com.youni.Youni.service;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.dto.AddSubjectRankingDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.exception.UniversityNotFoundException;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;

import java.util.List;

public interface YouniService {


  List<UniversityCourse> getAllUniCourse();

  List<UniversitySubject> getAllUniSubject();

  List<University> getAllUniversity();

  List<AlevelSubject> getAllAlevelSubject();

  List<CombineUniversityCourseAlevelSubject> getAllUniCourseAlevelCompKey();

  List<CombineUniversityUniversitySubject> addNewSubjectRanking(AddSubjectRankingDto subjectRankingDto) throws UniversityNotFoundException, UniversitySubjectNotFoundException;

  List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto);

  List<CombineUniversityUniversitySubject> getAllUniSubjectCompKey();
}
