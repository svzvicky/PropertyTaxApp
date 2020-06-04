package com.mindtree.taxapp.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:D:\\My-Garage-2\\SandBox\\mttaxapp2-maven\\WebContent\\WEB-INF\\taxAppContext.xml")
public class ReportControllerTest {

	@Autowired
	private ReportController reportController;

	@Test
	void Test(Model model) throws Exception {
		
		String view = reportController.showReportPage(model);
		Assertions.assertEquals("zonalreport", view);
		
	}

	@Test
	public void showReportPageTest(Model model) {

	}

}
