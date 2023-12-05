package com.youni.Youni.entity;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "courses")
public class Courses {


  @Id
  @Column(name="course_id", nullable = false)
  private Integer courseId;
//
//  @Column(name="course_name")
//  private Integer courseName;
//
//  @Column(name="degree_type")
//  private Integer degreeType;
//  @Column(name="course_length")
//  private Integer courseName;
//  @Column(name="required_grades_letters_upper")
//  private Integer courseName;
//  @Column(name="required_grades_letters_lower")
//  private Integer courseName;
//  @Column(name="year_industry")
//  private Integer courseName;
//  @Column(name="recommended_a-levels")
//  private Integer courseName;
//  @Column(name="is_masters")
//  private Integer courseName;
//  @Column(name="subject_id")
//  private Integer courseName;
//  @Column(name="required_grades_IB")
//  private Integer courseName;
//  @Column(name="UCAS_code")
//  private Integer courseName;

}
