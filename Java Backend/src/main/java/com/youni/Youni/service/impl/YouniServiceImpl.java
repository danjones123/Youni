package com.youni.Youni.service.impl;

import com.youni.Youni.entity.UniversityCourse;
import com.youni.Youni.repository.YouniRepository;
import com.youni.Youni.service.YouniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouniServiceImpl implements YouniService {

  @Autowired
  YouniRepository youniRepository;

  @Override
  public List<UniversityCourse> getAllCourse() {
    return youniRepository.findAll();
  }
}
