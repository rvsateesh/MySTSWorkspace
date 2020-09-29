package com.wf.training.mavenweb.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.wf.training.mavenweb.validators.CourseCode;

public class Student {
	
	// @NotBlank(message = "Name is mandatory!")
	@NotNull(message = "Name is mandatory!")
	private String name;
	
	private String email;
	
	private String country;
	
	private String favoriteLanguage;
	
	private String[] operatingSystems;
	
	// @NotBlank(message = "Free Passes are mandatory") // for string data
	// @NotEmpty(message = "Free Passes are mandatory") // for string data
	@NotNull(message = "Free Passes are mandatory")
	@Min(value = 1, message = "At least 1 free pass is required!")
	private Integer freePasses;
	
	@CourseCode(prefix="WF", message="Invalid Course code")
	private String courseCode; 
	
	
	private LinkedHashMap<String, String> countries;
	
	// populate the country list
	public Student() {
		// dummy values (can be fetched using DAO)
		this.countries = new LinkedHashMap<String, String>();
		this.countries.put("FR", "France");
		this.countries.put("IN", "India");
		this.countries.put("GR", "Germany");
		this.countries.put("US", "USA");
	}
	
	
	
	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	

	public Integer getFreePasses() {
		return freePasses;
	}



	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}



	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}



	public String[] getOperatingSystems() {
		return operatingSystems;
	}



	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}



	public String getCourseCode() {
		return courseCode;
	}



	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
