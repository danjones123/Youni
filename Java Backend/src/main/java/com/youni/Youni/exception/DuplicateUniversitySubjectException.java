package com.youni.Youni.exception;

public class DuplicateUniversitySubjectException extends Exception{
  public DuplicateUniversitySubjectException(String subj) {
    super("Duplicate university subject: " + subj);
  }
}
