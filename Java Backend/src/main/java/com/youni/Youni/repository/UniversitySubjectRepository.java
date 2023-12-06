package com.youni.Youni.repository;

import com.youni.Youni.entity.UniversityCourse;
import com.youni.Youni.entity.UniversitySubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversitySubjectRepository extends JpaRepository<UniversitySubject, Integer> {
}
