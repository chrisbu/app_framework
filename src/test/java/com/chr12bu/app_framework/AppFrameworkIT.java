package com.chr12bu.app_framework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chr12bu.app_framework.LearningLogApplication;


@SpringBootTest(classes = LearningLogApplication.class)
public class AppFrameworkIT {
	
    @Test
    public void contextLoads() {
	    
    }
    
    @Test
    public void mainTest() {
    	LearningLogApplication.main(new String[0]);
    }
}
