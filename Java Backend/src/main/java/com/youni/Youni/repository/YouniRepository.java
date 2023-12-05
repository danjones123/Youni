package com.youni.Youni.repository;

import com.youni.Youni.entity.UniversityCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YouniRepository extends JpaRepository<UniversityCourse, Integer> {
}
