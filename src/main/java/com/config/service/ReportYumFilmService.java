package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.config.entity.Film;
import com.config.entity.Invoice;
import com.config.entity.InvoiceDetail;
import com.config.repository.FilmRepository;
import com.config.repository.InvoiceDetailRepository;
import com.config.repository.InvoiceRepository;
import com.config.repository.OrderFoodRepository;

@Service
public class ReportYumFilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceDetailRepository invoiceDetailRepository;
	
	@Autowired
	OrderFoodRepository odfRepository;
	
	public Page<Film> getFilmTable(Pageable pageableFilm){
		return filmRepository.getFilmTable(pageableFilm);
	}
	public List<Film> getFilmStatustrue(){
		return filmRepository.getFilmStatusTrue();
	}
	public List<Invoice> getInvoiceStatusTrue(){
		return invoiceRepository.findInvoiceStatusTrue();
	}
	
	public List<InvoiceDetail> getInvoiceDetailAll(){
		return invoiceDetailRepository.findAllTicket();
	}
	
	public double getRevenue() {
		List<Object[]> listRevenue = invoiceDetailRepository.getRevenue();
		double revenue = 0;
		for(Object[] obj : listRevenue) {
			revenue = revenue + (double) obj[0];
		}
		return revenue;
	}
	
	public List<Object[]> getReportTop6Film(){
		
		return invoiceDetailRepository.getReportTop6Film();
	}
	

	public Page<Object[]> getFoodTable(Pageable pageable) {
		// TODO Auto-generated method stub
		return odfRepository.getFoodTable(pageable);
	}
	
	public List<Invoice> getTableInvoice(){
		return invoiceRepository.userTableReport();
	}
	
	public List<Object[]> getUserReport(){
		return invoiceDetailRepository.getUserReport();
	}
	
	public List<Object[]> getUserInvoiceReportPaymentStatusTrue(){
		return invoiceRepository.listUserInvoiceReportPaymentStatusTrue();
	}
	
	public List<Object[]> getUserInvoiceReportPaymentStatusFalse(){
		return invoiceRepository.listUserInvoiceReportPaymentStatusFalse();
	}
}
