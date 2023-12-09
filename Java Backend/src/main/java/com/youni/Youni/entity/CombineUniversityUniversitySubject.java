package com.youni.Youni.entity;

import com.youni.Youni.entity.compositekeys.CompKeyUniUniSubject;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "combine_university_university_subject")
public class CombineUniversityUniversitySubject {


  @EmbeddedId
  private CompKeyUniUniSubject compKeyUniUniSubject;

  @ManyToOne
  @MapsId("universityId")
  @JoinColumn(name = "university_id")
  private University university;

  @ManyToOne
  @MapsId("universitySubjectId")
  @JoinColumn(name = "university_subject_id")
  private UniversitySubject universitySubject;


  @Column(name="subject_ranking")
  private String subjectRanking;

}
