package com.youni.Youni.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ExpectedALevelGradesDto {
  public HashMap<String, String> alevelSubjectGrades;

}
