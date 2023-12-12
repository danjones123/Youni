package com.youni.Youni.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alevel_subject")
public class AlevelSubject {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "alevel_subject_id", nullable = false)
  private Integer alevelSubjectId;

  @Column(name = "alevel_subject_name")
  private String alevelSubjectName;

}
