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

	@Autowired
	FoodService foodService;

	@Autowired
	FilmService filmService;

	@Autowired
	SeatLocationService seatLocationService;

	@Autowired
	ShowTimeService showTimeService;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	UserService userService;
	
	Film film = new Film();
	Invoice invoice = new Invoice();
	InvoiceDetail invoiceDetail = new InvoiceDetail();
	ShowTime showTime = new ShowTime();
	SeatLocation seatLocation = new SeatLocation();
	String successSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"48\" height=\"48\" viewBox=\"0 0 48 48\"><defs><style>.a{fill:#e4f4ff;opacity:0;}.b{fill:none;stroke:#51d3c7;stroke-width:2px;}.c{fill:#51d3c7;}</style></defs><g transform=\"translate(-13.312 -114.115)\"><circle class=\"a\" cx=\"24\" cy=\"24\" r=\"24\" transform=\"translate(13.312 114.115)\"/></g><circle class=\"b\" cx=\"20\" cy=\"20\" r=\"20\" transform=\"translate(4 4)\"/><g transform=\"translate(-13.312 -112.115)\"><path class=\"c\" d=\"M35.94,142.629a1,1,0,0,1-.667-.255l-4.9-4.395A1,1,0,1,1,31.7,136.49l4.176,3.742,8.1-8.65a1,1,0,1,1,1.459,1.367l-8.772,9.364A1,1,0,0,1,35.94,142.629Z\"/></g></svg>";
	String warningSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"72\" height=\"72\" viewBox=\"0 0 72 72\">\r\n"
			+ "  <g id=\"Group_18129\" data-name=\"Group 18129\" transform=\"translate(-604 -170)\">\r\n"
			+ "    <circle id=\"Ellipse_148\" data-name=\"Ellipse 148\" cx=\"36\" cy=\"36\" r=\"36\" transform=\"translate(604 170)\" fill=\"#faeaea\"/>\r\n"
			+ "    <g id=\"_24x24-Alert\" data-name=\"24x24-Alert\" transform=\"translate(620 186)\">\r\n"
			+ "      <rect id=\"Frame24\" width=\"40\" height=\"40\" fill=\"#c91d1d\" opacity=\"0\"/>\r\n"
			+ "      <path id=\"alert\" d=\"M22.9,3.991l14.745,28.9A3.493,3.493,0,0,1,38,34.355a3.251,3.251,0,0,1-3.237,3.292H5.094a4.174,4.174,0,0,1-1.439-.366A3.3,3.3,0,0,1,2.4,32.891Q16.725,5.129,17.321,3.991A2.9,2.9,0,0,1,19.988,2.35,3.238,3.238,0,0,1,22.9,3.991ZM20,32.714a2.378,2.378,0,1,0-2.34-2.378A2.359,2.359,0,0,0,20,32.714ZM18.4,14.051v9.877a1.62,1.62,0,1,0,3.24,0V14.234a1.626,1.626,0,0,0-1.62-1.646A1.6,1.6,0,0,0,18.4,14.051Z\" transform=\"translate(0 -0.35)\" fill=\"#c91d1d\"/>\r\n"
			+ "    </g>\r\n" + "  </g>\r\n" + "</svg>";


	@GetMapping()
	public String showOder() {
		return "order";
	}


	@GetMapping("/orderFood")
	public String showOderFood(@RequestParam("showTime") int showTimeId, @RequestParam( value ="idFilm" , required = false) int id,
			@RequestParam("seatList") String[] seatList, @RequestParam("totalSeat") Float totalSeat, Model model) {
		System.out.println(id);
		showTime = showTimeService.findById(showTimeId);
		film = filmService.findById(id);
		model.addAttribute("showTime", showTime);
		model.addAttribute("Film", film);
		String seatsList = String.join(", ", seatList);
		model.addAttribute("seatList", seatsList);
		model.addAttribute("totalSeat", totalSeat);
		return "orderFood";
	}

	@PostMapping("/orderFood")
	public String showPay(
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
			return OrderFood.builder().invoice(invoice).food(food).price(food.getPrice()).quantity(Integer.parseInt(foodOrderSplit[1]))
					.build();
		}).toList();

		List<InvoiceDetail> invoiceDetails = Stream.of(seatList).map((s) -> {
			String[] seatSplit = s.split(" ");

			return InvoiceDetail.builder().invoice(invoice).seatLocation(seatLocationService.findBySeatNumber(seatSplit[0]))
					.price(Double.parseDouble(seatSplit[1])).showTime(showTimeService.findById(showTimeId)).build();
		}).toList();
		invoice.setListInvoiceDetail(invoiceDetails);
		invoice.setListOrderFood(orderFoods);
//		invoiceService.createInvoice(invoice);
		session.setAttribute("invoice", invoice);
		return "redirect:/booking/pay";
	}

	@GetMapping("/seat")
	public String oderSeat(@RequestParam(value = "idFilm", required = false) int idFilm, Model model) {
		film = filmService.findById(idFilm);
		showTime.setFilm(film);
		model.addAttribute("film", film);
		return "order";
	}


	@GetMapping("/pay")
	public String payment(Model model)
	{
		System.out.println("get /pay");
		Invoice invoice = (Invoice) session.getAttribute("invoice");
		
		List<InvoiceDetail> invoiceDetail = invoice.getListInvoiceDetail();
		
		String seatName = "";
		double seatPrice = 0;
		Map<String, Integer> orderFood = new HashMap();
		double foodPrice = 0;
		
		int count = 0;
		for (InvoiceDetail i : invoiceDetail) 
		{
			seatName = seatName.concat( " ," +i.getSeatLocation().getSeatNumber());
			seatPrice += i.getSeatLocation().getSeatType().getPrice() * i.getPrice();
			
			foodPrice += i.getInvoice().getListOrderFood().get(count).getPrice() * i.getInvoice().getListOrderFood().get(count).getQuantity();
			orderFood.put(
					i.getInvoice().getListOrderFood().get(count).getFood().getFoodName(),
					i.getInvoice().getListOrderFood().get(count).getQuantity());
			count++;
		}
		System.out.println("img: " +invoice.getListInvoiceDetail().get(0).getShowTime().getFilm().getFilmImage());
		model.addAttribute("invoice", invoice);
		
		String seatNameSplit = seatName.substring(2);
		
		
		model.addAttribute("seatName", seatNameSplit);
		model.addAttribute("seatPrice", seatPrice);
		model.addAttribute("foodPrice", foodPrice);
		model.addAttribute("orderFood", orderFood.entrySet());
		return "pay";
	}

	@PostMapping("/pay")
	public String thanhToan(Model model, @RequestParam("payment") int id) throws IOException {

		Invoice invoice = (Invoice) session.getAttribute("invoice");
		
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByUsername((String) authen.getPrincipal());
		
		invoice.setPayment(paymentService.selectById(id));
		invoice.setUser(user);
		invoice.setNote("Thanh toán qua VNPay !!");
		
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		String vnp_TmnCode = VNPayConfig.vnp_TmnCode;

//		  String vnp_OrderInfo = "Thanh toan qua VNPay"; // lời nhắn
//	        String orderType = "100000";
//	        String vnp_IpAddr = "13.160.92.202";

		long amount = (long) (invoice.getTotal() * 100);
		System.out.println(0);
		Map<String, String> vnp_Params = new HashMap<>();
		System.out.println(1);
		vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
		System.out.println(2);
		vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
		System.out.println(3);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		System.out.println(4);
		vnp_Params.put("vnp_Amount", String.valueOf(amount));
		System.out.println(5);
		vnp_Params.put("vnp_CurrCode", "VND");
		System.out.println(6);
//        String bank_code = req.getParameter("bankcode"); // mã ngân hàng. Nếu kh gửi mã ngân hàng thì auto cho chọn
//        if (bank_code != null && !bank_code.isEmpty()) {
		vnp_Params.put("vnp_BankCode", "NCB");
		System.out.println(7);
//        }
		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		System.out.println(8);
		vnp_Params.put("vnp_OrderInfo", "Thanh toan: " + String.valueOf(amount));
		System.out.println(9);
		vnp_Params.put("vnp_OrderType", String.valueOf(2));
		System.out.println(10);
		vnp_Params.put("vnp_Locale", "vn"); // địa chỉ ở việt nam
		System.out.println(11);

//        String locate = req.getParameter("language");
//        if (locate != null && !locate.isEmpty()) {
//            vnp_Params.put("vnp_Locale", locate);
//        } else {

//        }
		vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
		System.out.println(12);
		vnp_Params.put("vnp_IpAddr", "127.0.0.1");
		System.out.println(13);
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		System.out.println(14);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(15);
		String vnp_CreateDate = formatter.format(cld.getTime());
		System.out.println(16);

		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
		System.out.println(11);
		cld.add(Calendar.MINUTE, 17);
		System.out.println(18);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		System.out.println(19);
		// Add Params of 2.1.0 Version
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
		System.out.println(20);
//        //Billing
//        vnp_Params.put("vnp_Bill_Mobile", "vnp_Bill_Mobile");
//        vnp_Params.put("vnp_Bill_Email", "vnp_Bill_Email");
//        String fullName = ("Nguyen Man Dat");
//        if (fullName != null && !fullName.isEmpty()) {
//            int idx = fullName.indexOf(' ');
//            String firstName = fullName.substring(0, idx);
//            String lastName = fullName.substring(fullName.lastIndexOf(' ') + 1);
//            vnp_Params.put("vnp_Bill_FirstName", firstName);
//            vnp_Params.put("vnp_Bill_LastName", lastName);
//
//        }
//        vnp_Params.put("vnp_Bill_Address", "txt_inv_addr1");
//        vnp_Params.put("vnp_Bill_City", "txt_bill_city");
//        vnp_Params.put("vnp_Bill_Country", ("txt_bill_country"));
//        if (req.getParameter("txt_bill_state") != null && !req.getParameter("txt_bill_state").isEmpty()) {
//            vnp_Params.put("vnp_Bill_State", req.getParameter("txt_bill_state"));
//        }
		// Invoice
//        vnp_Params.put("vnp_Inv_Phone", "txt_inv_mobile");
//        vnp_Params.put("vnp_Inv_Email", "txt_inv_email");
//        vnp_Params.put("vnp_Inv_Customer", "txt_inv_customer");
//        vnp_Params.put("vnp_Inv_Address", "txt_inv_addr1");
//        vnp_Params.put("vnp_Inv_Company", "txt_inv_company");
//        vnp_Params.put("vnp_Inv_Taxcode", "txt_inv_taxcode");
//        vnp_Params.put("vnp_Inv_Type", "cbo_inv_type");
		// Build data to hash and querystring
		List fieldNames = new ArrayList(vnp_Params.keySet());
		System.out.println(21);
		Collections.sort(fieldNames);
		System.out.println(22);
		StringBuilder hashData = new StringBuilder();
		System.out.println(23);
		StringBuilder query = new StringBuilder();
		System.out.println(24);
		Iterator itr = fieldNames.iterator();
		System.out.println(25);
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
		System.out.println(26);
		String queryUrl = query.toString();
		System.out.println(27);
		String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
		System.out.println(28);
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		System.out.println(29);
		String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		System.out.println(30);
		com.google.gson.JsonObject job = new JsonObject();
		System.out.println(31);
		job.addProperty("code", "00");
		System.out.println(32);
		job.addProperty("message", "success");
		System.out.println(33);
		job.addProperty("data", paymentUrl);
		System.out.println(34);
		Gson gson = new Gson();
		System.out.println(35);
		System.out.println("vnp_TxnRef: " + vnp_TxnRef);
		System.out.println(36);
		System.out.println(37);
		System.out.println(38);

		invoiceService.createInvoice(invoice);
		session.setAttribute("invoice", invoice.getInvoiceId());
		System.out.println("invoice id in /pay: " + invoice.getInvoiceId());
		System.out.println(39);
//        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(job));
//        resp.getWriter().write(gson.toJson(job));
		 return "redirect:" +paymentUrl;
	}

	@GetMapping("/payment-status")
	public String paymentStatus(Model model) throws IOException {
		Object invoice = session.getAttribute("invoice");
		VNPayService vnpayService = new VNPayService();
		vnpayService.validVNPay(session, request, invoiceService);
		return "paymentStatus";
	}

	@ModelAttribute("listFood")
	public List<Food> getFood() {
		return foodService.findAll();
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
