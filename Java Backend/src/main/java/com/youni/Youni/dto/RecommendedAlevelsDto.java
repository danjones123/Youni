package com.youni.Youni.dto;

import com.youni.Youni.entity.SubjectWeight;
import lombok.Data;

@Data
public class RecommendedAlevelsDto {
  private String AlevelName;
  private SubjectWeight subjectWeight;
  private String minGrade;
}
