package com.chr12bu.app_framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.chr12bu.app_framework.model.Role;
import com.chr12bu.app_framework.repository.RoleRepository;


@SpringBootApplication
public class LearningLogApplication {

	Logger springEnhancedLogger = LoggerFactory.getLogger(getClass());
	Logger logger = LoggerFactory.getLogger("com.chr12bu.app_framework.LearningLogApplication");
	
	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LearningLogApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			logger.trace("Example trace message from LearningLogApplication.commandLineRunner");
			logger.debug("Example debug message from LearningLogApplication.commandLineRunner");
			logger.info("Example info message from LearningLogApplication.commandLineRunner");
			logger.warn("Exaple warn message from LearningLogApplication.commandLineRunner");
			logger.error("Example error message from LearningLogApplication.commandLineRunner");
			
			springEnhancedLogger.info("*** App Framework is RUNNING ***");
			
			Role adminRole = roleRepository.findByRole("ADMIN");
	        if (adminRole == null) {
	        	logger.info("First-run: Creating ADMIN role");
	            Role newAdminRole = new Role();
	            newAdminRole.setRole("ADMIN");
	            roleRepository.save(newAdminRole);
	        }

	        Role userRole = roleRepository.findByRole("USER");
	        if (userRole == null) {
	        	logger.info("First-run: Creating USER role");
	            Role newUserRole = new Role();
	            newUserRole.setRole("USER");
	            roleRepository.save(newUserRole);
	        }

		};
	}

}
