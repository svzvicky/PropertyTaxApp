package com.mindtree.taxapp.controllers;

import org.dom4j.rule.Mode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
public class ReportControllerTest {
	
	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
	  
	  @Test
	  void Test() {
		  mockMvc.perform(get('/'))
          .andExpect(status().isOk())
          .andExpect(forwardedUrl(''));
	  }
	  
	  @Test
	  public void showReportPageTest(Model model) {
		  
	  }


}
