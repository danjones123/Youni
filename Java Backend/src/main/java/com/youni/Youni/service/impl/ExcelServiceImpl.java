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

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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


  private AlevelSubject alevelSubject1;
  private AlevelSubject alevelSubject2;
  private AlevelSubject alevelSubject3;
  private AlevelSubject alevelSubject4;
  private AlevelSubject alevelSubject5;
  private CombineUniversityCourseAlevelSubject combineUniversityCourseAlevelSubject;
  private CombineUniversityUniversitySubject combineUniversityUniversitySubject;
  private University university;
  private UniversityCourse universityCourse;
  private UniversitySubject universitySubject;


  @Transactional
  public void saveFile(MultipartFile file) {
    try {
      List<ExcelHelperDTO> subjectList = ExcelHelper.excelToDb(file.getInputStream());

      for (ExcelHelperDTO excelDto : subjectList) {
        //Converts spreadsheet data into individual entities
        mapExcelData(excelDto);

        //If uni/subject/alevel already exist then gets the entity, otherwise saves and returns
        //Saved first as they do not have any foreign key constraints but are foreign keys for other tables
        University localUni = universityRepository.findByUniversityName(university.getUniversityName()).orElse(universityRepository.save(university));
        UniversitySubject localUniSubject = universitySubjectRepository.findByUniversitySubjectName(universitySubject.getUniversitySubjectName()).orElse(universitySubjectRepository.save(universitySubject));

        //Sets the foreign key parts of the other entities and saves
        universityCourse.setUniversity(localUni);
        universityCourse.setUniversitySubject(localUniSubject);
        UniversityCourse localUniCourse = universityCourseRepository.save(universityCourse);

        combineUniversityUniversitySubject.setUniversity(localUni);
        combineUniversityUniversitySubject.setUniversitySubject(localUniSubject);
        compKeyUniSubjectRepository.save(combineUniversityUniversitySubject);


        if (alevelSubject1 != null) {
          AlevelSubject localAlevel1 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject1.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject1));
          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel1);
          combineUniversityCourseAlevelSubject.setUniversityCourse(localUniCourse);
          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
        }

      }

    } catch (IOException e ){
      throw new RuntimeException("Failed to store excel: " + e.getMessage());
    }
  }


  private void mapExcelData(ExcelHelperDTO excelHelperDTO) {


    alevelSubject1 = ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);
    alevelSubject2 = ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);
    alevelSubject3 = ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);
    alevelSubject4 = ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);
    alevelSubject5 = ExcelToDbMapper.mapToAlevelSubject(excelHelperDTO);

    combineUniversityCourseAlevelSubject = ExcelToDbMapper.mapToUniversityCourseALevelSubject(excelHelperDTO);
    combineUniversityUniversitySubject = ExcelToDbMapper.mapToUniversityUniversitySubject(excelHelperDTO);
    university = ExcelToDbMapper.mapToUniversity(excelHelperDTO);
    universityCourse = ExcelToDbMapper.mapToUniversityCourse(excelHelperDTO);
    universitySubject = ExcelToDbMapper.mapToUniversitySubject(excelHelperDTO);



  }
}


//Read each column
  //If in db, get ID and add other details using that db
  //Else add to db and get details
//Check if course at uni already exists
