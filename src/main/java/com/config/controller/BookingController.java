package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
//	@PostMapping("/seat")
//	public String doOder(@RequestParam("seatList") String[] arrStr) {
//		System.out.println(arrStr);
//		return "index";
//	}
	
	@GetMapping("/orderFood")
	public String showOderFood(
			@RequestParam("showTime") int showTimeId,
			@RequestParam("idFilm") int id,
			@RequestParam("seatList") String[] seatList,
			@RequestParam("totalSeat") Float totalSeat,
			Model model
			) {
		showTime = showTimeService.findById(showTimeId);
		film = filmService.findById(id);
		model.addAttribute("showTime", showTime);
		model.addAttribute("Film", film);
		String seatsList = String.join(", ", seatList);
		model.addAttribute("seatList", seatsList);
		model.addAttribute("totalSeat", totalSeat);
		return "orderFood";
	}
	
	@GetMapping("/seat")
	public String oderSeat(
			@RequestParam("idFilm") int idFilm,
			Model model
			) {
		film = filmService.findById(idFilm);
		showTime.setFilm(film);
		model.addAttribute("film", film);
		return "order";
	}
	
	
	
	@GetMapping("/pay")
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
