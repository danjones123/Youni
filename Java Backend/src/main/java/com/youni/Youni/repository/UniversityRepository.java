package com.youni.Youni.repository;

import com.youni.Youni.entity.University;
import com.youni.Youni.entity.UniversityCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Integer> {

  Optional<University> findByUniversityName(String universityName);
}
