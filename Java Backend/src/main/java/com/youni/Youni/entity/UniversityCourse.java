package com.youni.Youni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university_course")
public class UniversityCourse {


  @Id
  @Column(name="university_course_id", nullable = false)
  private Integer universityCourseId;

  @JoinColumn(name="university_subject_id")
  @ManyToOne
  private UniversitySubject universitySubject;

  @Column(name="university_course_name")
  private String universityCourseName;
  @Column(name="university_course_length")
  private String universityCourseLength;
  @Column(name="degree_type")
  private String degreeType;
  @Column(name="UCAS_code")
  private String ucasCode;
  @Column(name="required_grades_letters_upper")
  private String requiredGradesLettersUpper;
  @Column(name="required_grades_letters_lower")
  private String requiredGradesLettersLower;
  @Column(name="required_grades_IB")
  private String requiredGradesIB;
  @Column(name="has_year_industry")
  private Boolean hasYearIndustry;
  @Column(name="has_foundation_year")
  private String hasFoundationYear;




}
