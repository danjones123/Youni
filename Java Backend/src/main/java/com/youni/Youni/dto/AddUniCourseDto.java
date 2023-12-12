package com.youni.Youni.dto;

import lombok.Data;

@Data
public class AddUniCourseDto {

  private String courseName;
  private String universityName;
  private String universitySubjectName;
  private String courseLengthYears;
  private String degreeType;
  private String ucasCode;
	private String requiredGradesLettersUpper;
  private String requiredGradesLettersLower;
  private String requiredGradesIB;
   private Boolean hasYearIndustry;
   private Boolean hasFoundationYear;
}
