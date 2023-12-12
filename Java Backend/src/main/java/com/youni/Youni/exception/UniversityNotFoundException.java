package com.youni.Youni.exception;

public class UniversityNotFoundException extends Exception{
  public UniversityNotFoundException(String university) {
    super("University " + university + " not found.");

  }
}
