package com.youni.Youni.service.impl;

import com.youni.Youni.entity.*;
import com.youni.Youni.helper.ExcelHelper;
import com.youni.Youni.helper.ExcelHelperDTO;
import com.youni.Youni.mapper.ExcelToDbMapper;
import com.youni.Youni.repository.*;
import com.youni.Youni.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

  @Autowired
  AlevelSubjectRepository alevelSubjectRepository;
  @Autowired
  CompKeyUniAlevelRepository compKeyUniAlevelRepository;
  @Autowired
  CompKeyUniSubjectRepository compKeyUniSubjectRepository;
  @Autowired
  UniversityCourseRepository universityCourseRepository;
  @Autowired
  UniversityRepository universityRepository;
  @Autowired
  UniversitySubjectRepository universitySubjectRepository;



  public void saveFile(MultipartFile file) {
    try {
      List<ExcelHelperDTO> subjectList = ExcelHelper.excelToDb(file.getInputStream());

      for (ExcelHelperDTO excelDto : subjectList) {
        mapAndSaveExcelData(excelDto);
      }

    } catch (IOException e ){
      throw new RuntimeException("Failed to store excel: " + e.getMessage());
    }
  }


  private void mapAndSaveExcelData(ExcelHelperDTO excelHelperDTO) {

    AlevelSubject alevelSubject= ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);
    CombineUniversityCourseAlevelSubject combineUniversityCourseAlevelSubject =
        ExcelToDbMapper.mapToUniversityCourseALevelSubject(excelHelperDTO);
    CombineUniversityUniversitySubject combineUniversityUniversitySubject =
        ExcelToDbMapper.mapToUniversityUniversitySubject(excelHelperDTO);
    University university = ExcelToDbMapper.mapToUniversity(excelHelperDTO);
    UniversityCourse universityCourse = ExcelToDbMapper.mapToUniversityCourse(excelHelperDTO);
    UniversitySubject universitySubject = ExcelToDbMapper.mapToUniversitySubject(excelHelperDTO);
  }
}


//Read each column
  //If in db, get ID and add other details using that db
  //Else add to db and get details
//Check if course at uni already exists
