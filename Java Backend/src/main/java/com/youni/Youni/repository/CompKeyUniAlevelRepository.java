package com.youni.Youni.repository;

import com.youni.Youni.entity.CombineUniversityCourseAlevelSubject;
import com.youni.Youni.entity.UniversityCourse;
import com.youni.Youni.entity.compositekeys.CompKeyUniCourseAlevelSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompKeyUniAlevelRepository extends JpaRepository<CombineUniversityCourseAlevelSubject, Integer> {
  List<CombineUniversityCourseAlevelSubject> findByUniversityCourse(UniversityCourse universityCourse);
}
