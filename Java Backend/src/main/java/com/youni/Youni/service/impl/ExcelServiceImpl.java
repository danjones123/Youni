package com.youni.Youni.service.impl;

import com.youni.Youni.entity.*;
import com.youni.Youni.entity.compositekeys.CompKeyUniCourseAlevelSubject;
import com.youni.Youni.entity.compositekeys.CompKeyUniUniSubject;
import com.youni.Youni.exception.UniversitySubjectNotFoundException;
import com.youni.Youni.exception.UnrecognizedUniversityException;
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
import java.util.ArrayList;
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

  private ArrayList<CombineUniversityCourseAlevelSubject> combineUniversityCourseAlevelSubjectList;
  private CombineUniversityUniversitySubject combineUniversityUniversitySubject;
  private University university;
  private UniversityCourse universityCourse;
  private UniversitySubject universitySubject;


  @Transactional
  public void saveFile(MultipartFile file) throws UnrecognizedUniversityException {
    try {
      List<ExcelHelperDTO> subjectList = ExcelHelper.excelToDb(file.getInputStream());

      for (ExcelHelperDTO excelDto : subjectList) {
        //Converts spreadsheet data into individual entities
        mapExcelData(excelDto);

        //If uni/subject/alevel already exist then gets the entity, otherwise saves and returns
        //Saved first as they do not have any foreign key constraints but are foreign keys for other tables
        University localUni = universityRepository.findByUniversityName(university.getUniversityName()).orElseThrow(
            () ->  new UnrecognizedUniversityException("University " + university.getUniversityName() + " not recognised"));
        Optional<UniversitySubject> optionalUniversitySubject = universitySubjectRepository.findByUniversitySubjectName(universitySubject.getUniversitySubjectName());
        UniversitySubject localUniSubject = optionalUniversitySubject.orElseGet(() -> universitySubjectRepository.save(universitySubject));
//        localUniSubject = universitySubjectRepository.findByUniversitySubjectName(
//            universitySubject.getUniversitySubjectName()).orElse(universitySubjectRepository.save(universitySubject));

        //Sets the foreign key parts of the other entities and saves
        universityCourse.setUniversity(localUni);
        universityCourse.setUniversitySubject(localUniSubject);
        UniversityCourse localUniCourse = universityCourseRepository.save(universityCourse);

        CompKeyUniUniSubject compKeyUniUniSubject = new CompKeyUniUniSubject();
        compKeyUniUniSubject.setUniversityId(localUni.getUniversityId());
        compKeyUniUniSubject.setUniversitySubjectId(localUniSubject.getUniversitySubjectId());
        combineUniversityUniversitySubject.setCompKeyUniUniSubject(compKeyUniUniSubject);
        combineUniversityUniversitySubject.setUniversity(localUni);
        combineUniversityUniversitySubject.setUniversitySubject(localUniSubject);
        compKeyUniSubjectRepository.save(combineUniversityUniversitySubject);

        for(CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject : combineUniversityCourseAlevelSubjectList) {
          CompKeyUniCourseAlevelSubject compKeyUniCourseAlevelSubject = new CompKeyUniCourseAlevelSubject();
          compKeyUniCourseAlevelSubject.setUniversityCourseId(localUniCourse.getUniversityCourseId());
          combineUniAndAlevelSubject.setUniversityCourse(localUniCourse);

          Optional<AlevelSubject> optionalAlevelSubject = alevelSubjectRepository.findByAlevelSubjectName(combineUniAndAlevelSubject.getAlevelSubject().getAlevelSubjectName());
          AlevelSubject localAlevel = optionalAlevelSubject.orElseGet(() -> alevelSubjectRepository.save(combineUniAndAlevelSubject.getAlevelSubject()));

//          AlevelSubject localAlevel = alevelSubjectRepository.findByAlevelSubjectName(combineUniAndAlevelSubject.getAlevelSubject().getAlevelSubjectName()).orElse(alevelSubjectRepository.save(combineUniAndAlevelSubject.getAlevelSubject()));
          compKeyUniCourseAlevelSubject.setAlevelSubjectId(localAlevel.getAlevelSubjectId());
          combineUniAndAlevelSubject.setAlevelSubject(localAlevel);
          combineUniAndAlevelSubject.setCompKeyUniCourseAlevelSubject(compKeyUniCourseAlevelSubject);
          compKeyUniAlevelRepository.save(combineUniAndAlevelSubject);
        }



        //Varying sizes of recommended subjects so checks all and then
//        if (alevelSubject1 != null) {
//          AlevelSubject localAlevel1 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject1.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject1));
//          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel1);
//          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
//        }

//        if (alevelSubject2 != null) {
//          AlevelSubject localAlevel2 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject2.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject2));
//          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel2);
//          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
//        }
//
//        if (alevelSubject3 != null) {
//          AlevelSubject localAlevel3 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject3.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject3));
//          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel3);
//          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
//        }
//
//        if (alevelSubject4 != null) {
//          AlevelSubject localAlevel4 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject4.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject4));
//          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel4);
//          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
//        }
//
//        if (alevelSubject5 != null) {
//          AlevelSubject localAlevel5 = alevelSubjectRepository.findByAlevelSubjectName(alevelSubject5.getAlevelSubjectName()).orElse(alevelSubjectRepository.save(alevelSubject5));
//          combineUniversityCourseAlevelSubject.setAlevelSubject(localAlevel5);
//          compKeyUniAlevelRepository.save(combineUniversityCourseAlevelSubject);
//        }

      }

    } catch (IOException e ){
      e.printStackTrace();
      throw new RuntimeException("Failed to store excel: " + e.getMessage());
    } catch (UnrecognizedUniversityException e) {
      e.printStackTrace();
      throw new UnrecognizedUniversityException(e.getMessage());
    }
  }


  private void mapExcelData(ExcelHelperDTO excelHelperDTO) {

    combineUniversityCourseAlevelSubjectList = ExcelToDbMapper.mapToUniversityCourseALevelSubject(excelHelperDTO);

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
