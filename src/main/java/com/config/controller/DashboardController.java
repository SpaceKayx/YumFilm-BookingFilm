package com.config.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.entity.Film;
import com.config.service.ReportYumFilmService;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
 
	@Autowired
	ReportYumFilmService rpService;
	
	@GetMapping()
	public String dashboard(Model model) {
		int listFilmSize = rpService.getFilmStatustrue().size();
		model.addAttribute("listFilmSize", listFilmSize);
		
		int listInvoice = rpService.getInvoiceStatusTrue().size();
		model.addAttribute("listInvoice", listInvoice);
		
		int listInvoiceDetail = rpService.getInvoiceDetailAll().size();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		
		Double revenue = rpService.getRevenue();
		model.addAttribute("revenue", revenue);
		
		List<Object[]> top6FilmReport = rpService.getReportTop6Film();
		model.addAttribute("top6FilmReport", top6FilmReport);
		
		
		return "dashboard/index";
	}
	
	@GetMapping("chartjs")
	public String chartjs() {
		
		return "dashboard/pages/charts/chartjs";
	}
	
	@GetMapping("tables")
	public String tables(Model model,
			@RequestParam("pageFood") Optional<Integer> pageFood,
			@RequestParam("pageFilm") Optional<Integer> pageFilm
			) {

		Pageable pageableFood = PageRequest.of(pageFood.orElse(0), 4);
		Page<Object[]> pagesFood = rpService.getFoodTable(pageableFood);
		model.addAttribute("pagesFood", pagesFood);
		
		Pageable pageableFilm = PageRequest.of(pageFilm.orElse(0), 4);
		Page<Film>  pagesFilm = rpService.getFilmTable(pageableFilm);
		model.addAttribute("pagesFilm", pagesFilm);
		
		List<Object[]> pagesUser = rpService.getUserReport();
		model.addAttribute("listUserReport",pagesUser);
		
		List<Object[]> listInvoiceUser = rpService.getUserInvoiceReportPaymentStatusTrue();
		model.addAttribute("listInvoiceUser", listInvoiceUser);
		
		List<Object[]> listInvoiceUserFalse = rpService.getUserInvoiceReportPaymentStatusFalse();
		model.addAttribute("listInvoiceUserFalse", listInvoiceUserFalse);
		
		return "dashboard/pages/tables/basic-table";
	}

	@GetMapping("forms")
	public String formElement() {
		
		return "dashboard/pages/forms/basic_elements";
	}
	
	@GetMapping("icons")
	public String icons() {
		
		return "dashboard/pages/icons/themify";
	}
	
	@RequestMapping("/tables/pageFood")
	public String pageFood(@RequestParam("pageFood") Optional<Integer> pageFood, Model model 
			, @RequestParam("pageFilm") Optional<Integer> pageFilm
			) {
	
		Pageable pageableFood = PageRequest.of(pageFood.orElse(0), 4);
		Page<Object[]> pagesFood = rpService.getFoodTable(pageableFood);
		model.addAttribute("pagesFood", pagesFood);
		
		Pageable pageableFilm = PageRequest.of(pageFilm.orElse(0), 4);
		Page<Film> pagesFilm = rpService.getFilmTable(pageableFilm);
		model.addAttribute("pagesFilm", pagesFilm);

		
		
		return "dashboard/pages/tables/basic-table";
	}
	
	@RequestMapping("/tables/pageFilm")
	public String pageFilm(@RequestParam("pageFilm") Optional<Integer> pageFilm,
			
			@RequestParam("pageFood") Optional<Integer> pageFood,
			Model model) {
		
		Pageable pageableFood = PageRequest.of(pageFood.orElse(0), 4);
		Page<Object[]> pagesFood = rpService.getFoodTable(pageableFood);
		model.addAttribute("pagesFood", pagesFood);

		Pageable pageableFilm = PageRequest.of(pageFilm.orElse(0), 4);
		Page<Film> pagesFilm = rpService.getFilmTable(pageableFilm);
		model.addAttribute("pagesFilm", pagesFilm);

		
		
		return "dashboard/pages/tables/basic-table";
	}
	
	
}
