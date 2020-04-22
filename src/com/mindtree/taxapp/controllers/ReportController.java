package com.mindtree.taxapp.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.services.TaxService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	private static final Logger logger = Logger.getLogger(ReportController.class);
	
	@Autowired
	TaxService taxService;
	
	@RequestMapping("/zonal")
	public String showReportPage(Model model) {
		List<Report> reportUI = taxService.zonalReport();
		model.addAttribute("reportUI", reportUI);
		logger.info("Report Loaded");
		logger.debug(reportUI);
		return "zonalreport";
	}

}
