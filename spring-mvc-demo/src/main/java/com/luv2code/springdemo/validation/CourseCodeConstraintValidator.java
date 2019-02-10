package com.luv2code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

  private String code;

  @Override
  public void initialize(CourseCode courseCode) {
    this.code = courseCode.value();
  }

  @Override
  public boolean isValid(String code, ConstraintValidatorContext context) {
    return code != null ? code.startsWith(this.code) : true;
  }

}
