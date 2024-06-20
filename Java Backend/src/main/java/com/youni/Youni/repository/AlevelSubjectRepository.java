package com.youni.Youni.repository;

import com.youni.Youni.entity.AlevelSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AlevelSubjectRepository extends JpaRepository<AlevelSubject, Integer> {
  Optional<AlevelSubject> findByAlevelSubjectName(String subjectName);
}
