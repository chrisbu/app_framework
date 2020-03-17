package com.chr12bu.app_framework.controller.mvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloMvcControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHello() throws Exception {	
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/api/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attribute("firstName", "Chris"))
				.andExpect(model().attribute("surname", "Buckett"));
		
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mv = mvcResult.getModelAndView();
		assertNotNull(mv);
	}

}
