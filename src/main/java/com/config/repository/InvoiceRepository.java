package com.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.config.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

	@Query(value = "SELECT i FROM Invoice i WHERE i.status = true")
	List<Invoice> findInvoiceStatusTrue();
	
	@Query(value = "SELECT i FROM Invoice i WHERE i.status = true AND i.user.status = true")
	List<Invoice> userTableReport();
	
	@Query( value = "WITH TotalInvoice AS ("
			+ "		SELECT  Invoice.InvoiceId, SUM(InvoiceDetail.Price) AS Total"
			+ "		FROM Invoice JOIN InvoiceDetail ON Invoice.InvoiceId = InvoiceDetail.InvoiceId"
			+ "		WHERE Invoice.Status = 1"
			+ "		GROUP BY Invoice.InvoiceId"
			+ "), "
			+ "TotalOrderFood AS("
			+ "		SELECT  Invoice.InvoiceId, SUM(OrderFood.Price) AS Total"
			+ "		FROM OrderFood "
			+ "			JOIN Food ON OrderFood.FoodId = FOOD.FoodId"
			+ "			JOIN Invoice ON Invoice.InvoiceId = OrderFood.InvoiceId"
			+ "		WHERE Invoice.Status = 1"
			+ "		GROUP BY Invoice.InvoiceId"
			+ ")"
			+ "SELECT Users.LastName + ' ' + Users.FirstName AS FullName"
			+ "		, Invoice.CreateDate "
			+ "		, Invoice.InvoiceId "
			+ "		, TotalOrderFood.Total + TotalInvoice.Total AS Total "
			+ "		, Invoice.paymentStatus "
			+ "FROM Invoice "
			+ "			LEFT JOIN Users ON Users.UserId = Invoice.UserId "
			+ "			LEFT JOIN TotalInvoice on Invoice.InvoiceId = TotalInvoice.InvoiceId	"
			+ "			LEFT JOIN TotalOrderFood on Invoice.InvoiceId = TotalOrderFood.InvoiceId	"
			+ "WHERE Invoice.STATUS = 1 AND Invoice.paymentStatus = 1 "
			+ "ORDER BY Invoice.CreateDate desc " ,nativeQuery = true)
	List<Object[]> listUserInvoiceReportPaymentStatusTrue();
	
	@Query( value = "WITH TotalInvoice AS ("
			+ "		SELECT  Invoice.InvoiceId, SUM(InvoiceDetail.Price) AS Total"
			+ "		FROM Invoice JOIN InvoiceDetail ON Invoice.InvoiceId = InvoiceDetail.InvoiceId"
			+ "		WHERE Invoice.Status = 1"
			+ "		GROUP BY Invoice.InvoiceId"
			+ "), "
			+ "TotalOrderFood AS("
			+ "		SELECT  Invoice.InvoiceId, SUM(OrderFood.Price) AS Total"
			+ "		FROM OrderFood "
			+ "			JOIN Food ON OrderFood.FoodId = FOOD.FoodId"
			+ "			JOIN Invoice ON Invoice.InvoiceId = OrderFood.InvoiceId"
			+ "		WHERE Invoice.Status = 1"
			+ "		GROUP BY Invoice.InvoiceId"
			+ ")"
			+ "SELECT Users.LastName + ' ' + Users.FirstName AS FullName"
			+ "		, Invoice.CreateDate "
			+ "		, Invoice.InvoiceId "
			+ "		, TotalOrderFood.Total + TotalInvoice.Total AS Total "
			+ "		, Invoice.paymentStatus "
			+ "FROM Invoice "
			+ "			LEFT JOIN Users ON Users.UserId = Invoice.UserId "
			+ "			LEFT JOIN TotalInvoice on Invoice.InvoiceId = TotalInvoice.InvoiceId	"
			+ "			LEFT JOIN TotalOrderFood on Invoice.InvoiceId = TotalOrderFood.InvoiceId	"
			+ "WHERE Invoice.STATUS = 1 AND Invoice.paymentStatus = 0 "
			+ "ORDER BY Invoice.CreateDate desc " ,nativeQuery = true)
	List<Object[]> listUserInvoiceReportPaymentStatusFalse();
}
