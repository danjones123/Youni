package com.youni.Youni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university_subject")
public class UniversitySubject {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="university_subject_id", nullable = false)
  private Integer universitySubjectId;

  @Column(name="university_subject_name")
  private String universitySubjectName;





}
