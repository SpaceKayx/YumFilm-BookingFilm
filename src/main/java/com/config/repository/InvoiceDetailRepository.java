package com.config.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	@Query(value = "SELECT id FROM InvoiceDetail id where id.invoice.status =true")
	List<InvoiceDetail> findAllTicket();
	
	@Query(value = "WITH TotalInvoice AS ( " +
            "    SELECT Invoice.InvoiceId, SUM(InvoiceDetail.Price) AS Total " +
            "    FROM Invoice " +
            "    JOIN InvoiceDetail ON Invoice.InvoiceId = InvoiceDetail.InvoiceId " +
            "    WHERE Invoice.Status = 1 " +
            "    GROUP BY Invoice.InvoiceId " +
            "), " +
            "TotalOrderFood AS ( " +
            "    SELECT Invoice.InvoiceId, SUM(OrderFood.Price) AS Total " +
            "    FROM OrderFood " +
            "    JOIN FOOD ON OrderFood.FoodId = FOOD.FoodId " +
            "    JOIN Invoice ON Invoice.InvoiceId = OrderFood.InvoiceId " +
            "    WHERE Invoice.Status = 1 " +
            "    GROUP BY Invoice.InvoiceId " +
            ") " +
            "SELECT ISNULL(TotalOrderFood.Total,0)  + ISNULL(TotalInvoice.Total,0) AS TOTAL " +
            "FROM Invoice " +
            " LEFT JOIN TotalInvoice ON Invoice.InvoiceId = TotalInvoice.InvoiceId " +
            " LEFT JOIN TotalOrderFood ON Invoice.InvoiceId = TotalOrderFood.InvoiceId " +
            "WHERE Invoice.Status = 1 " +
            "ORDER BY Invoice.InvoiceId ", nativeQuery = true)
	List<Object[]> getRevenue();
	
	@Query(value = "SELECT f.filmName, f.filmImage, f.price, COUNT(id.invoiceDetailId) , SUM(id.price)"
			+ " FROM InvoiceDetail id "
			+ " JOIN id.invoice i"
			+ "	JOIN id.showTime st"
			+ " JOIN st.film f"
			+ " GROUP BY f.filmName, f.filmImage, f.price "
			+ " ORDER BY COUNT(id.invoiceDetailId) DESC")
	List<Object[]> getReportTop6Film();
	
	@Query(value = 
			"WITH TotalInvoice AS ("
		            + " SELECT  SUM(InvoiceDetail.Price) AS Total, Invoice.InvoiceId  "
		            + " FROM Invoice "
		            + " JOIN InvoiceDetail ON Invoice.InvoiceId = InvoiceDetail.InvoiceId "
		            + " WHERE Invoice.Status = 1 "
		            + " GROUP BY Invoice.InvoiceId"
		            + "), TotalOrderFood AS ("
		            + " SELECT Invoice.InvoiceId, SUM(OrderFood.Price) AS Total "
		            + " FROM OrderFood "
		            + " JOIN Food ON OrderFood.FoodId = Food.FoodId "
		            + " JOIN Invoice ON Invoice.InvoiceId = OrderFood.InvoiceId "
		            + " WHERE Invoice.Status = 1 "
		            + " GROUP BY Invoice.InvoiceId"
		            + ") "
		            + "SELECT users.lastName + ' ' + users.firstName as FullName, "
		            + " users.PhoneNumber, "
		            + " users.email, "
		            + " COUNT(TotalInvoice.InvoiceId) as Total_Invoice, "
		            + " SUM(COALESCE(TotalOrderFood.Total, 0) + COALESCE(TotalInvoice.Total, 0)) AS TOTAL "
		            + "FROM Invoice "
		            + " LEFT JOIN Users ON Invoice.UserId = Users.UserId "
		            + " LEFT JOIN TotalInvoice ON Invoice.InvoiceId = TotalInvoice.InvoiceId "
		            + " LEFT JOIN TotalOrderFood ON Invoice.InvoiceId = TotalOrderFood.InvoiceId "
		            + "WHERE Invoice.Status = 1 "
		            + "GROUP BY users.lastName, users.firstName, users.PhoneNumber, users.email "
		            + "ORDER BY SUM(COALESCE(TotalOrderFood.Total, 0) + COALESCE(TotalInvoice.Total, 0)) DESC" , nativeQuery = true)
	List<Object[]> getUserReport();

}
