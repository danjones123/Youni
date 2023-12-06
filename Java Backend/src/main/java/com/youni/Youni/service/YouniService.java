package com.youni.Youni.service;

import com.youni.Youni.entity.*;

import java.util.List;

public interface YouniService {


  List<UniversityCourse> getAllUniCourse();

  List<UniversitySubject> getAllUniSubject();

  List<University> getAllUniversity();

  List<AlevelSubject> getAllAlevelSubject();

  List<CombineUniversityCourseAlevelSubject> getAllCompKey();
}
