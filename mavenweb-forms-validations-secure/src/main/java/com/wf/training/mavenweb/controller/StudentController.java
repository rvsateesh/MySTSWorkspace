package com.wf.training.mavenweb.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wf.training.mavenweb.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/home")
	public String home() {
		return "student-home";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		System.out.println(principal.getName());
		Student student = new Student();  // empty bag
		// student.setName("Dummy");
		model.addAttribute("student", student);
		return "student-profile";
	}
	
	// @ModelAttribute will put the param data into model object
	// @Valid : Checks the constraint
	// Share with us the result
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfile(@Valid @ModelAttribute Student student, 
							  BindingResult result) {
		// pass the student object to view page to display
		// check the result of constraint check
		if(result.hasErrors()) {
			return "student-profile";
		}
		
		return "student-confirm";
	}
	
	// interceptor to filter the incoming
	// Filter in Servlet API
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// define rules to customize data
		// auto trim the leading and trailing spacee
		StringTrimmerEditor trimmer = 
				new StringTrimmerEditor(true);
		// true : empty string will be converted to null
		binder.registerCustomEditor(String.class, trimmer);
		
		
	}
}

















