package com.youni.Youni.service;

import com.youni.Youni.dto.AddSubjectDto;
import com.youni.Youni.entity.*;
import com.youni.Youni.exception.UniversityNotFoundException;

import java.util.List;

public interface YouniService {


  List<UniversityCourse> getAllUniCourse();

  List<UniversitySubject> getAllUniSubject();

  List<University> getAllUniversity();

  List<AlevelSubject> getAllAlevelSubject();

  List<CombineUniversityCourseAlevelSubject> getAllCompKey();

  List<UniversitySubject> addNewSubject(AddSubjectDto subjectDto) throws UniversityNotFoundException;
}
