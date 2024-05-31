package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.entity.Film;
import com.config.entity.Food;
import com.config.entity.Invoice;
import com.config.entity.InvoiceDetail;
import com.config.entity.SeatLocation;
import com.config.entity.ShowTime;
import com.config.service.FilmService;
import com.config.service.FoodService;
import com.config.service.SeatLocationService;
import com.config.service.ShowTimeService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	SeatLocationService seatLocationService;
	
	@Autowired
	ShowTimeService showTimeService;

	Film film = new Film();
	Invoice invoice = new Invoice();
	InvoiceDetail invoiceDetail = new InvoiceDetail();
	ShowTime showTime = new ShowTime();
	SeatLocation seatLocation = new SeatLocation();
	
	@GetMapping()
	public String showOder() {
		return "order";
	}
	
	@PostMapping("/orderFood")
	public String showOderFood() {
		return "orderFood";
	}
	
	@RequestMapping("/seat")
	public String oderSeat(
			@RequestParam("idFilm") int idFilm,
			Model model
			) {
		film = filmService.findById(idFilm);
		showTime.setFilm(film);
		model.addAttribute("listFilm", film);
		

		
		return "order";
	}
	
	
	
	
	@PostMapping("/pay")
	public String pay()
	{
		return"pay";
	}
	
	@ModelAttribute("listFood")
	public List<Food> getFood(){
		return foodService.findAll();
	}
	
	@ModelAttribute("listSeat")
	public List<SeatLocation> getSeat(){
		return seatLocationService.findAll();
	}
	
	@ModelAttribute("listShowTime")
	public List<Object[]> getFilmShowTime(@RequestParam("idFilm") int idFilm){
		return showTimeService.getFilmShowTime(idFilm);
	}
}
