package com.youni.Youni.mapper;

import com.youni.Youni.entity.*;
import com.youni.Youni.helper.ExcelHelperDTO;

import java.util.ArrayList;
import java.util.Locale;

public class ExcelToDbMapper {


  public static ArrayList<CombineUniversityCourseAlevelSubject> mapToUniversityCourseALevelSubject(ExcelHelperDTO excelHelperDTO) {

    ArrayList<CombineUniversityCourseAlevelSubject> outputList = new ArrayList<>();


//    ArrayList<AlevelSubject> outputList = new ArrayList<>();

    if (excelHelperDTO.getAlevel1() != null && !excelHelperDTO.getAlevel1().equals("") && !excelHelperDTO.getAlevel1().equals("null")) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel1());
//      UniversityCourse universityCourse = new UniversityCourse();
//      universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());

      CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject = new CombineUniversityCourseAlevelSubject();
      combineUniAndAlevelSubject.setAlevelSubject(alevelSubject);
//      combineUniAndAlevelSubject.setUniversityCourse(universityCourse);
      combineUniAndAlevelSubject.setMinGrade(excelHelperDTO.getAlevelGrade1());
      combineUniAndAlevelSubject.setRequiredWeight(enumConverter(excelHelperDTO.getRecType1()));


      outputList.add(combineUniAndAlevelSubject);
    }

    if (excelHelperDTO.getAlevel2() != null && !excelHelperDTO.getAlevel2().equals("") && !excelHelperDTO.getAlevel2().equals("null")) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel2());
//      UniversityCourse universityCourse = new UniversityCourse();
//      universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());

      CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject = new CombineUniversityCourseAlevelSubject();
      combineUniAndAlevelSubject.setAlevelSubject(alevelSubject);
//      combineUniAndAlevelSubject.setUniversityCourse(universityCourse);
      combineUniAndAlevelSubject.setMinGrade(excelHelperDTO.getAlevelGrade2());
      combineUniAndAlevelSubject.setRequiredWeight(enumConverter(excelHelperDTO.getRecType2()));


      outputList.add(combineUniAndAlevelSubject);
    }
    if (excelHelperDTO.getAlevel3() != null && !excelHelperDTO.getAlevel3().equals("") && !excelHelperDTO.getAlevel3().equals("null")) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel3());
//      UniversityCourse universityCourse = new UniversityCourse();
//      universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());

      CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject = new CombineUniversityCourseAlevelSubject();
      combineUniAndAlevelSubject.setAlevelSubject(alevelSubject);
//      combineUniAndAlevelSubject.setUniversityCourse(universityCourse);
      combineUniAndAlevelSubject.setMinGrade(excelHelperDTO.getAlevelGrade3());
      combineUniAndAlevelSubject.setRequiredWeight(enumConverter(excelHelperDTO.getRecType3()));


      outputList.add(combineUniAndAlevelSubject);
    }

    if (excelHelperDTO.getAlevel4() != null && !excelHelperDTO.getAlevel4().equals("") && !excelHelperDTO.getAlevel4().equals("null")) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel4());
//      UniversityCourse universityCourse = new UniversityCourse();
//      universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());

      CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject = new CombineUniversityCourseAlevelSubject();
      combineUniAndAlevelSubject.setAlevelSubject(alevelSubject);
//      combineUniAndAlevelSubject.setUniversityCourse(universityCourse);
      combineUniAndAlevelSubject.setMinGrade(excelHelperDTO.getAlevelGrade4());
      combineUniAndAlevelSubject.setRequiredWeight(enumConverter(excelHelperDTO.getRecType4()));


      outputList.add(combineUniAndAlevelSubject);
    }

    if (excelHelperDTO.getAlevel5() != null && !excelHelperDTO.getAlevel5().equals("") && !excelHelperDTO.getAlevel5().equals("null")) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel5());
//      UniversityCourse universityCourse = new UniversityCourse();
//      universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());

      CombineUniversityCourseAlevelSubject combineUniAndAlevelSubject = new CombineUniversityCourseAlevelSubject();
      combineUniAndAlevelSubject.setAlevelSubject(alevelSubject);
//      combineUniAndAlevelSubject.setUniversityCourse(universityCourse);
      combineUniAndAlevelSubject.setMinGrade(excelHelperDTO.getAlevelGrade5());
      combineUniAndAlevelSubject.setRequiredWeight(enumConverter(excelHelperDTO.getRecType5()));


      outputList.add(combineUniAndAlevelSubject);
    }

    return outputList;

  }

  public static CombineUniversityUniversitySubject mapToUniversityUniversitySubject(ExcelHelperDTO excelHelperDTO) {
    CombineUniversityUniversitySubject combineUniversityUniversitySubject = new CombineUniversityUniversitySubject();
    combineUniversityUniversitySubject.setSubjectRanking(excelHelperDTO.getUniversitySubjectRank());
    return combineUniversityUniversitySubject;
  }

  public static University mapToUniversity(ExcelHelperDTO excelHelperDTO) {
    University university = new University();
    university.setUniversityName(excelHelperDTO.getUniversityName());


    return university;
  }

  public static UniversityCourse mapToUniversityCourse(ExcelHelperDTO excelHelperDTO) {
    UniversityCourse universityCourse = new UniversityCourse();
    universityCourse.setUniversityCourseName(excelHelperDTO.getCourseName());
    universityCourse.setUniversityCourseLength(excelHelperDTO.getCourseLength());
    universityCourse.setDegreeType(excelHelperDTO.getDegreeType());
    universityCourse.setUcasCode(excelHelperDTO.getUCASCode());
    universityCourse.setRequiredGradesLettersUpper(excelHelperDTO.getRequiredGradesUpper());
    universityCourse.setRequiredGradesLettersLower(excelHelperDTO.getRequiredGradesLower());
    universityCourse.setRequiredGradesIB(excelHelperDTO.getRequiredIB());
    universityCourse.setHasYearIndustry(convertYesOrNo(excelHelperDTO.getYearIndustry()));
    universityCourse.setHasFoundationYear(convertYesOrNo(excelHelperDTO.getFoundationYear()));
    return universityCourse;
  }

  public static UniversitySubject mapToUniversitySubject(ExcelHelperDTO excelHelperDTO) {
    UniversitySubject universitySubject = new UniversitySubject();
    universitySubject.setUniversitySubjectName(excelHelperDTO.getUniversitySubject());

    return universitySubject;
  }

  public static ArrayList<AlevelSubject> mapToAlevelSubject(ExcelHelperDTO excelHelperDTO) {

    ArrayList<AlevelSubject> outputList = new ArrayList<>();

    if (!excelHelperDTO.getAlevel1().equals("") && excelHelperDTO.getAlevel1() != null) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel1());
      outputList.add(alevelSubject);
    }

    if (!excelHelperDTO.getAlevel2().equals("") && excelHelperDTO.getAlevel2() != null) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel2());
      outputList.add(alevelSubject);
    }

    if (!excelHelperDTO.getAlevel3().equals("") && excelHelperDTO.getAlevel3() != null) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel3());
      outputList.add(alevelSubject);
    }

    if (!excelHelperDTO.getAlevel4().equals("") && excelHelperDTO.getAlevel4() != null) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel4());
      outputList.add(alevelSubject);
    }

    if (!excelHelperDTO.getAlevel5().equals("") && excelHelperDTO.getAlevel5() != null) {
      AlevelSubject alevelSubject = new AlevelSubject();
      alevelSubject.setAlevelSubjectName(excelHelperDTO.getAlevel5());
      outputList.add(alevelSubject);
    }

    return outputList;
  }

  private static SubjectWeight enumConverter(String toConvert) {
    try {
      return SubjectWeight.valueOf(toConvert.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("Invalid subject weight: " + toConvert);
    }
  }

  private static boolean convertYesOrNo(String toConvert) {
    return toConvert.equals("Y") || toConvert.equals("y");
  }
}
