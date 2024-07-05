package com.youni.Youni.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UniCourseAndRecommendedAlevels {
  private String courseName;
  private String universityName;
  private String universitySubjectName;
  private String minGrades;
  private String subjectRank;
  private ArrayList<RecommendedAlevelsDto> alevelSubjects;

}
