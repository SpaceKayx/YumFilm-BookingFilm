package com.config.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Invoice;
import com.config.repository.InvoiceRepository;

@Service
public class InvoiceService 
{
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public Invoice createInvoice(Invoice invoice)
	{
		System.out.println("CREATE INVOICE");
		System.out.println(invoice.getInvoiceId());
		if(selectById((int) invoice.getInvoiceId()) != null)
		{
			throw new IllegalArgumentException("Invoice đã tồn tại !!");
		}
		return invoiceRepository.save(invoice);
	}
	
	public Invoice selectById(int id)
	{
		System.out.println("SELECT BY ID");
		System.out.println(id);
		Optional<Invoice> opt_invoice =  invoiceRepository.findById(id);
		System.out.println(2);
		if(opt_invoice.isPresent())
		{
//			System.out.println("hihi: " +opt_invoice.get());
			return opt_invoice.get();
		}
		System.out.println(3);
		return null;
	}
	public Invoice updateInvoice(Invoice invoice)
	{
		if(selectById((int) invoice.getInvoiceId()) != null)
		{
			return invoiceRepository.save(invoice);
		}
		throw new IllegalArgumentException("Invoice chưa tồn tại !!");
	}
}
