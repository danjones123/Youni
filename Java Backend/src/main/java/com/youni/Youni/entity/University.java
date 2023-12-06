package com.youni.Youni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")
public class University {


  @Id
  @Column(name="university_id", nullable = false)
  private Integer universityId;


  @Column(name="university_name")
  private String universityeName;
  @Column(name="university_location")
  private String universityLocation;
  @Column(name="university_prospectus_link")
  private String universtyProspectusLink;
  @Column(name="university_ranking")
  private String universityRanking;





}
