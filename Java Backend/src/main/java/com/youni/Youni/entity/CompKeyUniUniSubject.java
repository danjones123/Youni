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
public class CompKeyUniUniSubject implements Serializable {
  @Column(name="university_id")
  private Integer universityId;

  @Column(name="university_subject_id")
  private Integer universitySubjectId;
}

