package com.youni.Youni.repository;

import com.youni.Youni.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YouniRepository extends JpaRepository<Courses, Integer> {
}
