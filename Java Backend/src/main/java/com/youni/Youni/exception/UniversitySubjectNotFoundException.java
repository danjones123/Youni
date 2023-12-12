package com.youni.Youni.exception;

public class UniversitySubjectNotFoundException extends Exception{
  public UniversitySubjectNotFoundException(String subjectName) {
    super("Subject " + subjectName + " not found");
  }
}
