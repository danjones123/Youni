package com.youni.Youni.dto;

import lombok.Data;

@Data
public class SuggestedSubjectAndUniversityDto {
  private String universityName;
  private String subjectName;
  private String courseName;
  private String subjectRanking;
  private Integer recommendedWeighting;
}
