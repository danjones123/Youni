package com.youni.Youni.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERS = { "University Name","University Subject","University Subject Rank","Course Name",
      "Course Length","Degree Type","Required Grades Upper","Required Grades Lower","Required Letters","Year Industry",
      "UCAS Code","Foundation Year","Alevel 1","Alevel Grade 1","Rec Type 1","Alevel 2","Alevel Grade 2","Rec Type 2",
      "Alevel 3","Alevel Grade 3","Rec Type 3","Alevel 4","Alevel Grade 4","Rec Type 4","Alevel 5","Alevel Grade 5",
      "Rec Type 5" };
  static String SHEET = "University Courses POC";


  public static boolean hasExcelFormat(MultipartFile file) {
    return TYPE.equals(file.getContentType());
  }


  public static List<ExcelHelperDTO> excelToDb(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<ExcelHelperDTO> excelHelperDTOS = new ArrayList<>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        ExcelHelperDTO excelHelperDTO = new ExcelHelperDTO();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
            case 0:
              excelHelperDTO.setUniversityName(currentCell.getStringCellValue());
              break;

            case 1:
              excelHelperDTO.setUniversitySubject(currentCell.getStringCellValue());
              break;

            case 2:
              excelHelperDTO.setUniversitySubjectRank(currentCell.getStringCellValue());
              break;

            case 3:
              excelHelperDTO.setCourseName(currentCell.getStringCellValue());
              break;

            case 4:
              excelHelperDTO.setCourseLength(currentCell.getStringCellValue());
              break;

            case 5:
              excelHelperDTO.setDegreeType(currentCell.getStringCellValue());
              break;

            case 6:
              excelHelperDTO.setRequiredGradesUpper(currentCell.getStringCellValue());
              break;

            case 7:
              excelHelperDTO.setRequiredGradesLower(currentCell.getStringCellValue());
              break;

            case 8:
              excelHelperDTO.setRequiredLetters(currentCell.getStringCellValue());
              break;

            case 9:
              excelHelperDTO.setYearIndustry(currentCell.getStringCellValue());
              break;

            case 10:
              excelHelperDTO.setUCASCode(currentCell.getStringCellValue());
              break;

            case 11:
              excelHelperDTO.setFoundationYear(currentCell.getStringCellValue());
              break;

            case 12:
              excelHelperDTO.setAlevel1(currentCell.getStringCellValue());
              break;

            case 13:
              excelHelperDTO.setAlevelGrade1(currentCell.getStringCellValue());
              break;

            case 14:
              excelHelperDTO.setRecType1(currentCell.getStringCellValue());
              break;

            case 15:
              excelHelperDTO.setAlevel2(currentCell.getStringCellValue());
              break;

            case 16:
              excelHelperDTO.setAlevelGrade2(currentCell.getStringCellValue());
              break;

            case 17:
              excelHelperDTO.setRecType2(currentCell.getStringCellValue());
              break;

            case 18:
              excelHelperDTO.setAlevel3(currentCell.getStringCellValue());
              break;

            case 19:
              excelHelperDTO.setAlevelGrade3(currentCell.getStringCellValue());
              break;


            case 20:
              excelHelperDTO.setRecType3(currentCell.getStringCellValue());
              break;

            case 21:
              excelHelperDTO.setAlevel4(currentCell.getStringCellValue());
              break;

            case 22:
              excelHelperDTO.setAlevelGrade4(currentCell.getStringCellValue());
              break;

            case 23:
              excelHelperDTO.setRecType4(currentCell.getStringCellValue());
              break;

            case 24:
              excelHelperDTO.setAlevel5(currentCell.getStringCellValue());
              break;

            case 25:
              excelHelperDTO.setAlevelGrade5(currentCell.getStringCellValue());
              break;

            case 26:
              excelHelperDTO.setRecType5(currentCell.getStringCellValue());
              break;

            default:
              break;
          }

          cellIdx++;
        }

        excelHelperDTOS.add(excelHelperDTO);
      }

      workbook.close();

      return excelHelperDTOS;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }

}