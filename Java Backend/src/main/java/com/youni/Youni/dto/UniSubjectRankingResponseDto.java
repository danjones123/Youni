package com.youni.Youni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniSubjectRankingResponseDto {

  private String universityName;
  private String subjectName;
  private String subjectRanking;
}
