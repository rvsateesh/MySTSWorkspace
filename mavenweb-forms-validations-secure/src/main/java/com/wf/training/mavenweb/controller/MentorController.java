package com.wf.training.mavenweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	@RequestMapping("/home")
	public String home() {
		return "mentor-home";
	}
}
