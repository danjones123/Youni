package com.youni.Youni.dto;

import com.youni.Youni.entity.CombineUniversityCourseAlevelSubject;
import com.youni.Youni.entity.UniversityCourse;
import lombok.Data;

import java.util.List;

@Data
public class UniCourseRequiredSubjects {
  private UniversityCourse universityCourse;
  private List<CombineUniversityCourseAlevelSubject> uniCourseAlevelSubjectList;
}
