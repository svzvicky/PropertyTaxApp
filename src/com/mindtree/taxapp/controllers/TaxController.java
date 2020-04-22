package com.mindtree.taxapp.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.taxapp.model.Category;
import com.mindtree.taxapp.model.TaxAssessment;
import com.mindtree.taxapp.model.Zone;
import com.mindtree.taxapp.services.CategoryService;
import com.mindtree.taxapp.services.TaxService;
import com.mindtree.taxapp.services.ZoneService;

@Controller
public class TaxController {
	
	private static final Logger logger = Logger.getLogger(TaxController.class);
	
	@Autowired
	CategoryService categoryservice;
	@Autowired
	ZoneService zoneService;
	@Autowired
	TaxService taxService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}

	@RequestMapping("/")
	public String showHomePage() {
		logger.info("Home Page Loaded");
		return "index";
	}

	@RequestMapping("/assessment")
	public String showAssessment(Model model) {
		List<Category> categories = categoryservice.getCategories();
		List<Zone> zones = zoneService.getZones();
		// logger.info(zones);
		model.addAttribute("zones", zones);
		model.addAttribute("categories", categories);
		model.addAttribute("taxAssessment", new TaxAssessment());
		return "taxassessment";
	}

	@RequestMapping(value = "/saveTax", method = RequestMethod.POST)
	public String saveTax(@Valid @ModelAttribute("taxAssessment") TaxAssessment taxAssessment, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			List<Category> categories = categoryservice.getCategories();
			List<Zone> zones = zoneService.getZones();
			model.addAttribute("zones", zones);
			model.addAttribute("categories", categories);
			return "taxassessment";
		} else {
			String message = "Tax details are saved successfully";
			boolean flag = false;
			try {
				flag = taxService.saveTaxFiling(taxAssessment);
			} catch (Exception ex) {
				logger.error(ex);
				flag = false;
			}
			logger.debug("Save Flag Value=" + flag);
			if (flag) {
				model.addAttribute("message", message);
				logger.info(message);
				return "index";
			}
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/calculatetax")
	@ResponseBody
	public float calculateTax(HttpServletRequest request) {

		String zone = request.getParameter("zone");
		logger.debug("Selected Zone=" + zone);

		int category = Integer.parseInt(request.getParameter("category"));
		logger.debug("Selected Category=" + category);

		String status = request.getParameter("status");
		logger.debug("Selected Status=" + status);

		int year = Integer.parseInt(request.getParameter("Year"));
		logger.debug("Enetered Year=" + year);

		float buildingArea = Float.parseFloat(request.getParameter("buildingArea"));
		logger.debug("Entered Bulding Area=" + buildingArea);

		double totalTax = taxService.taxCalculation(zone, category, status, year, buildingArea);

		DecimalFormat df = new DecimalFormat("#.##");
		float totalTax1 = Float.parseFloat(df.format(totalTax));

		return totalTax1;
	}
}