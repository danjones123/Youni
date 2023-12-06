package com.youni.Youni.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CompKeyUniCourseAlevelSubject implements Serializable {
  @Column(name="university_course_id")
  private Integer universityCourseId;

  @Column(name="alevel_subject_id")
  private Integer alevelSubjectId;
}
