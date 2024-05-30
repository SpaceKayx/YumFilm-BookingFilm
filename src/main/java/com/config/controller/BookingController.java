package com.config.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.dto.PaymentResDTO;
import com.config.entity.Invoice;
import com.config.entity.InvoiceDetail;
import com.config.entity.OrderFood;
import com.config.entity.Payment;
import com.config.entity.User;
import com.config.entity.Voucher;
import com.config.service.UserService;
import com.config.utils.Auth;
import com.config.vnpay.VNPayConfig;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/booking")
public class BookingController {

	String successSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"48\" height=\"48\" viewBox=\"0 0 48 48\"><defs><style>.a{fill:#e4f4ff;opacity:0;}.b{fill:none;stroke:#51d3c7;stroke-width:2px;}.c{fill:#51d3c7;}</style></defs><g transform=\"translate(-13.312 -114.115)\"><circle class=\"a\" cx=\"24\" cy=\"24\" r=\"24\" transform=\"translate(13.312 114.115)\"/></g><circle class=\"b\" cx=\"20\" cy=\"20\" r=\"20\" transform=\"translate(4 4)\"/><g transform=\"translate(-13.312 -112.115)\"><path class=\"c\" d=\"M35.94,142.629a1,1,0,0,1-.667-.255l-4.9-4.395A1,1,0,1,1,31.7,136.49l4.176,3.742,8.1-8.65a1,1,0,1,1,1.459,1.367l-8.772,9.364A1,1,0,0,1,35.94,142.629Z\"/></g></svg>";
	String warningSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"72\" height=\"72\" viewBox=\"0 0 72 72\">\r\n"
			+ "  <g id=\"Group_18129\" data-name=\"Group 18129\" transform=\"translate(-604 -170)\">\r\n"
			+ "    <circle id=\"Ellipse_148\" data-name=\"Ellipse 148\" cx=\"36\" cy=\"36\" r=\"36\" transform=\"translate(604 170)\" fill=\"#faeaea\"/>\r\n"
			+ "    <g id=\"_24x24-Alert\" data-name=\"24x24-Alert\" transform=\"translate(620 186)\">\r\n"
			+ "      <rect id=\"Frame24\" width=\"40\" height=\"40\" fill=\"#c91d1d\" opacity=\"0\"/>\r\n"
			+ "      <path id=\"alert\" d=\"M22.9,3.991l14.745,28.9A3.493,3.493,0,0,1,38,34.355a3.251,3.251,0,0,1-3.237,3.292H5.094a4.174,4.174,0,0,1-1.439-.366A3.3,3.3,0,0,1,2.4,32.891Q16.725,5.129,17.321,3.991A2.9,2.9,0,0,1,19.988,2.35,3.238,3.238,0,0,1,22.9,3.991ZM20,32.714a2.378,2.378,0,1,0-2.34-2.378A2.359,2.359,0,0,0,20,32.714ZM18.4,14.051v9.877a1.62,1.62,0,1,0,3.24,0V14.234a1.626,1.626,0,0,0-1.62-1.646A1.6,1.6,0,0,0,18.4,14.051Z\" transform=\"translate(0 -0.35)\" fill=\"#c91d1d\"/>\r\n"
			+ "    </g>\r\n" + "  </g>\r\n" + "</svg>";

	@Autowired
	HttpServletRequest request;

	@Autowired
	UserService userService;

	@GetMapping()
	public String showOder() {
		return "order";
	}

	@GetMapping("/orderFood")
	public String showOderFood() {
		return "orderFood";
	}

	@GetMapping("/pay")
	public String pay() {
		return "pay";
	}

	@PostMapping("/pay")
	public ResponseEntity<?> payment() throws UnsupportedEncodingException {

		int invoiceID = 10;
		Date date = new Date();
		boolean paymentStatus = false;
		String note = "note của invoice1";
		double total = 100000000;
		boolean status = false; // trạng thái hóa đơn, còn tồn tại không

		int value_in_voucher = 35;
		Voucher voucher = new Voucher(invoiceID, "voucher name1", date, date, value_in_voucher, status, null);

		Authentication authen = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByUsername((String) authen.getPrincipal());

		Payment payment = new Payment(0, "Thanh toan vnpay1", status, null);

		List<OrderFood> list_orderFood = new ArrayList<>();

		List<InvoiceDetail> list_invoiceDetail = new ArrayList<>();

		Invoice i = new Invoice(invoiceID, date, paymentStatus, note, total, status, voucher, user, payment,
				list_orderFood, list_invoiceDetail);
		System.out.println(user.getUsername());
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		String vnp_TmnCode = VNPayConfig.vnp_TmnCode;

		long amount = (long) i.getTotal();

//        int amount = Integer.parseInt(req.getParameter("amount")) * 100;
		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
		vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(amount));
		vnp_Params.put("vnp_CurrCode", "VND");

		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		// nội dung thanh toán
		vnp_Params.put("vnp_OrderInfo", "Thanh toan: " + String.valueOf(amount));
		// mã danh mục hàng hóa, do vnpay quy định
		vnp_Params.put("vnp_OrderType", String.valueOf(2));

		vnp_Params.put("vnp_Locale", "vn");
//        }
		vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
		vnp_Params.put("vnp_IpAddr", "127.0.0.1");
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());

		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
		cld.add(Calendar.MINUTE, 15);
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
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
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
		PaymentResDTO paymentDTO = new PaymentResDTO();
		paymentDTO.setMessage("Payment Successfully !!");
		paymentDTO.setSatus("OK");
		paymentDTO.setUrl(paymentUrl);
		System.out.println("queryUrl: " +queryUrl);
		System.out.println("vnp_SecureHash: " +vnp_SecureHash);
		
		return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
	}

	@GetMapping("/payment-status")
	public String paymentStatus(Model model)
	{
	    //Begin process return from VNPAY
	    Map fields = new HashMap();
	    for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
		    String fieldName = (String) params.nextElement();
		    String fieldValue = request.getParameter(fieldName);
		    if ((fieldValue != null) && (fieldValue.length() > 0)) {
		        fields.put(fieldName, fieldValue);
		    }
	    }
	    String vnp_SecureHash = request.getParameter("vnp_SecureHash");
	    System.out.println("vnp_SecureHash in status: " +vnp_SecureHash);
	    if (fields.containsKey("vnp_SecureHashType")) {
	    fields.remove("vnp_SecureHashType");
	    }
	    if (fields.containsKey("vnp_SecureHash")) {
	    fields.remove("vnp_SecureHash");
	    }
	    String signValue = VNPayConfig.hashAllFields(fields);
	    System.out.println("signValue: " +signValue);
	    if (signValue.equals(vnp_SecureHash)) {
	        if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
	            model.addAttribute("message", "Giao dịch thành công !!");
	        } else {
	            model.addAttribute("message", "Giao dịch không thành công !!");
	        }
	    
	    } else {
            model.addAttribute("message", "Chữ ký không hợp lệ !!");
	    }
		
		return "paymentStatus";
	}
}
