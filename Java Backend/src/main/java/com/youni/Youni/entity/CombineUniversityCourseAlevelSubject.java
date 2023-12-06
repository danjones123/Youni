package com.youni.Youni.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "combine_university_course_alevel_subject")
public class CombineUniversityCourseAlevelSubject {


  @EmbeddedId
  private CompKeyUniCourseAlevelSubject compKeyUniCourseAlevelSubject;

  @ManyToOne
  @MapsId("universityCourseId")
  @JoinColumn(name = "university_course_id")
  private UniversityCourse universityCourse;

  @ManyToOne
  @MapsId("alevelSubjectId")
  @JoinColumn(name = "alevel_subject_id")
  private AlevelSubject alevelSubject;

  @Column(name="min_grade")
  private String minGrade;

}
