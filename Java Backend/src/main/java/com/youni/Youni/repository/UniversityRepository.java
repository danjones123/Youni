package com.youni.Youni.repository;

import com.youni.Youni.entity.University;
import com.youni.Youni.entity.UniversityCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Integer> {
}
