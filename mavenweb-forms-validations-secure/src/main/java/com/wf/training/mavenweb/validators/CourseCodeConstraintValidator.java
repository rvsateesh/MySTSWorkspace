package com.wf.training.mavenweb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  
			 implements ConstraintValidator<CourseCode, String>{
	
	private String expectedPrefix;
	
	// method will have access over annotation attr.
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		this.expectedPrefix = constraintAnnotation.prefix();
	}
	
	@Override
	public boolean isValid(String actualCode, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(actualCode.startsWith(expectedPrefix))
			return true;
		return false;
	}
}












