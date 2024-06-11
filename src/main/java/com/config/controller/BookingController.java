package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.config.entity.Invoice;
import com.config.entity.InvoiceDetail;
import com.config.entity.OrderFood;
import com.config.entity.Payment;
import com.config.entity.User;
import com.config.entity.Voucher;
import com.config.service.InvoiceService;
import com.config.service.PaymentService;
import com.config.service.UserService;
import com.config.service.VNPayService;
import com.config.vnpay.VNPayConfig;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/booking")
public class BookingController {

//	Start Autowired Service
	
	@Autowired
	FoodService foodService;
	@Autowired
	FilmService filmService;
	@Autowired
	SeatLocationService seatLocationService;
	@Autowired
	ShowTimeService showTimeService;
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	UserService userService;

//	End Autowired Service
	
// Start Scope
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
// End Scope
	
//	Start Entity
	Film film = new Film();
	Invoice invoice = new Invoice();
	InvoiceDetail invoiceDetail = new InvoiceDetail();
	ShowTime showTime = new ShowTime();
	SeatLocation seatLocation = new SeatLocation();
//	End Entity
	
	@GetMapping()
	public String showOder() 
	{
		return "order";
	}


	@GetMapping("/orderFood")
	public String showOderFood(@RequestParam(value = "showTime", required = false) Integer showTimeId, 
			@RequestParam( value = "idFilm" , required = false) Integer id,
			@RequestParam(value = "seatList", required = false) String[] seatList, 
			@RequestParam(value = "totalSeat", required = false) Float totalSeat, Model model) {
		showTime = showTimeService.findById(showTimeId);
		film = filmService.findById(id);
		
		String seatsList = String.join(", ", seatList);
		
		model.addAttribute("showTime", showTime);
		model.addAttribute("Film", film);
		model.addAttribute("seatList", seatsList);
		model.addAttribute("totalSeat", totalSeat);
		
		return "orderFood";
	}

	@PostMapping("/orderFood")
	public String postOrderFood(
			@RequestParam("showTime") Integer showTimeId, @RequestParam("idFilm") int id,
			@RequestParam("seatList") String[] seatList, @RequestParam("totalPrice") Double totalPrice,
			@RequestParam("foodOrder") String[] foodOrder, Model model
			) {
		Invoice invoice = Invoice.builder()
				.total(totalPrice)
				.build();
		List<OrderFood> orderFoods = Stream.of(foodOrder).map((f) -> {
			String[] foodOrderSplit = f.split(" ");
			Integer foodId = Integer.parseInt(foodOrderSplit[0]);
			Food food = foodService.findById(foodId);
			return OrderFood.builder()
					.invoice(invoice)
					.food(food)
					.quantity(Integer.parseInt(foodOrderSplit[1]))
					.price(food.getPrice() * Integer.parseInt(foodOrderSplit[1]))
					.build();
		}).toList();

		List<InvoiceDetail> invoiceDetails = Stream.of(seatList).map((s) -> {
			String[] seatSplit = s.split(" ");
			return InvoiceDetail.builder().invoice(invoice).seatLocation(seatLocationService.findBySeatNumber(seatSplit[0]))
					.price(Double.parseDouble(seatSplit[1])).showTime(showTimeService.findById(showTimeId)).build();
		}).toList();
		
		invoice.setListInvoiceDetail(invoiceDetails);
		invoice.setListOrderFood(orderFoods);
		
		session.setAttribute("invoice", invoice);
	
		return "redirect:/booking/pay";
	}

	@GetMapping("/seat")
	public String orderSeat(@RequestParam(value = "idFilm", required = false) int idFilm, Model model) {
		film = filmService.findById(idFilm);
		
		showTime.setFilm(film);
		
		model.addAttribute("film", film);
		
		return "order";
	}

	@GetMapping("/pay")
	public String showPayment(Model model)
	{
		Invoice invoice = (Invoice) session.getAttribute("invoice");
		List<OrderFood> orderFood = invoice.getListOrderFood();
		
		List<InvoiceDetail> invoiceDetail = invoice.getListInvoiceDetail();
		
		String seatName = "";
		double seatPrice = 0;
		double foodPrice = 0;
		
		for (InvoiceDetail i : invoiceDetail) 
		{
			seatName = seatName.concat( " ," +i.getSeatLocation().getSeatNumber());
//			seatPrice += i.getSeatLocation().getSeatType().getPrice() * i.getPrice();
			seatPrice += i.getPrice();
		}
		for (OrderFood food : orderFood) {
			foodPrice += food.getPrice();
		}
		String seatNameSplit = seatName.substring(2);
		
		model.addAttribute("invoice", invoice);
		model.addAttribute("orderFood", orderFood);
		model.addAttribute("seatName", seatNameSplit);
		model.addAttribute("seatPrice", seatPrice);
		model.addAttribute("foodPrice", foodPrice);
		
		return "pay";
	}

	@PostMapping("/pay")
	public String postPayment(Model model, @RequestParam("payment") int id) throws IOException {

		Invoice invoice = (Invoice) session.getAttribute("invoice");
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername((String) authen.getPrincipal());
		
		invoice.setPayment(paymentService.selectById(id));
		invoice.setUser(user);
		invoice.setNote("Thanh toán qua VNPay !!");
		long amount = (long) (invoice.getTotal() * 100);
		
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
		
		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
		vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(amount));
		vnp_Params.put("vnp_CurrCode", "VND");
		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", "Thanh toan: " + String.valueOf(amount) + "cho Yum Film");
		vnp_Params.put("vnp_OrderType", String.valueOf(2));
		vnp_Params.put("vnp_Locale", "vn"); // địa chỉ ở việt nam
		vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
		vnp_Params.put("vnp_IpAddr", "127.0.0.1");
		
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());

		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
		
		cld.add(Calendar.MINUTE, 17);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
		
		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		StringBuilder hashData = new StringBuilder();
		StringBuilder query = new StringBuilder();
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) vnp_Params.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				// Build hash data
				hashData.append(fieldName);
				hashData.append('=');
				hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				// Build query
				query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
				query.append('=');
				query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				if (itr.hasNext()) {
					query.append('&');
					hashData.append('&');
				}
			}
		}
		String queryUrl = query.toString();
		String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		com.google.gson.JsonObject job = new JsonObject();
		job.addProperty("code", "00");
		job.addProperty("message", "success");
		job.addProperty("data", paymentUrl);

		invoiceService.createInvoice(invoice);
		session.setAttribute("invoice", invoice.getInvoiceId());
		 return "redirect:" +paymentUrl;
	}

	@GetMapping("/payment-status")
	public String paymentStatus(Model model) throws IOException {
		VNPayService vnpayService = new VNPayService();
		vnpayService.validVNPay(session, request, invoiceService);
		return "paymentStatus";
	}

	@ModelAttribute("listFood")
	public List<Food> getFood() {
		return foodService.selectAll();
	}

	@ModelAttribute("listSeat")
	public List<SeatLocation> getSeat() {
		return seatLocationService.findAll();
	}

	@ModelAttribute("listShowTime")
	public List<Object[]> getFilmShowTime(@RequestParam( value = "idFilm", required = false) Integer idFilm) {
		if(idFilm != null) return showTimeService.getFilmShowTime(idFilm);
		return null;
	}
}
