package com.youni.Youni.service;

import com.youni.Youni.exception.UnrecognizedUniversityException;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {
  public void saveFile(MultipartFile file) throws UnrecognizedUniversityException;
}
