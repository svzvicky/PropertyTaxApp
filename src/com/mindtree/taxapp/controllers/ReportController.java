package com.mindtree.taxapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.taxapp.model.Report;
import com.mindtree.taxapp.services.TaxService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	TaxService taxService;
	
	@RequestMapping("/zonal")
	public String showReportPage(Model model) {
		List<Report> reportUI = taxService.zonalReport();
		model.addAttribute("reportUI", reportUI);
		return "zonalreport";
	}

}
