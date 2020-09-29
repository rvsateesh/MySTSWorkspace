package com.wf.training.mavenweb.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


// use this annotation as a constraint ann.
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // runtime/compile
public @interface CourseCode { // to represent annotation
	// attribute of annotation
	// values assigned to attribute will be returned by these method
	public String prefix() default "WF";
	public String message() default "Invalid Code!!!";
	
	// boiler-plate code for constraint annotation
	// two mandatory attributes
	
	// 1. groups : used to chain multiple constraint
	public Class<?>[] groups() default {};
	
	// 2. payload : additional info about validation (severity level, error code...)
	public Class<? extends Payload>[]  payload() default{};
	
}











