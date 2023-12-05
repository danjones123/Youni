package com.youni.Youni.controller;

import com.youni.Youni.dto.UniCourseDto;
import com.youni.Youni.entity.Courses;
import com.youni.Youni.service.YouniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/youni")
public class YouniController {

  @Autowired
  private YouniService youniService;

  @GetMapping
  public List<Courses> getAllCourses() {


    return youniService.getAllCourse();
  }
}
