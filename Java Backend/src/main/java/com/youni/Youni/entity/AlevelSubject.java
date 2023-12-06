package com.youni.Youni.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alevel_subject")
public class AlevelSubject {


  @Id
  @Column(name = "alevel_subject_id", nullable = false)
  private Integer alevelSubjectId;

  @Column(name = "alevel_subject_name")
  private String alevelSubjectName;

}
