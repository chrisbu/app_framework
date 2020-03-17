package com.chr12bu.app_framework.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chr12bu.app_framework.model.SomeModel;
import com.chr12bu.app_framework.model.User;
import com.chr12bu.app_framework.repository.SomeModelRepository;

@RestController
public class HelloApiController {

	@Autowired
	private SomeModelRepository providerRepo;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/api/")
	public String api() {
		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
		
		return "Greetings from Spring Boot";
	}
	
	@GetMapping("/api/hello") 
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("firstName", "Chris");
	    modelAndView.addObject("surname","Buckett");
	    modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@GetMapping("/api/mongo")
	public List<SomeModel> mongo() {
		providerRepo.deleteAll();
		
		providerRepo.save(new SomeModel("Udemy", "www.udemy.com"));
		providerRepo.save(new SomeModel("Coursera", "www.coursera.com"));
		
		return providerRepo.findAll();
		
		
	}
	
}
