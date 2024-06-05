package com.config.testExcel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.config.entity.Film;
import com.config.service.CountryService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class FilmExcelExport {
	 private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private List<Film> listFilm;
	     

	    public FilmExcelExport(List<Film> listFilm) {
	        this.listFilm = listFilm;
	        workbook = new XSSFWorkbook();
	    }
	 
	 
	    private void writeHeaderLine() {
	        sheet = workbook.createSheet("Films");
	         
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	        createCell(row, 0, "FilmName", style);      
	        createCell(row, 1, "FilmTime", style);       
	        createCell(row, 2, "PremiereDate", style);    
	        createCell(row, 3, "Price", style);
	        createCell(row, 4, "Country", style);
	        createCell(row, 5, "Age", style);
	        createCell(row, 6, "Rate", style);
	        createCell(row, 7, "Status", style);
	         
	    }
	     
	    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        } else if (value instanceof Boolean) {
	            cell.setCellValue((Boolean) value);
	        }else if (value instanceof Date) {
	        	
	        	CellStyle cellStyle = workbook.createCellStyle();
	        	CreationHelper createHelper = workbook.getCreationHelper();
	        	cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MMM-yyyy"));
	        	cell.setCellValue((Date) value);
	        	cell.setCellStyle(cellStyle);
	        	System.out.println(value);
//	            cell.setCellValue((Date) value);
	        }else if (value instanceof Double) {
	            cell.setCellValue((Double) value);
	        }else {
	            cell.setCellValue((String) value);
	        }
//	        cell.setCellStyle(style);
	        
	        // Apply the provided style to the cell if it is not a Date
	        if (!(value instanceof Date)) {
	            cell.setCellStyle(style);
	        }
	    }
	     
	    private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	                 
	        for (Film film : listFilm) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            
	            createCell(row, columnCount++, film.getFilmName(), style);
	            createCell(row, columnCount++, film.getFilmTime(), style);
	            createCell(row, columnCount++, film.getPremiereDate(), style);
	            createCell(row, columnCount++, film.getPrice(), style);
	            createCell(row, columnCount++, film.getCountry().getCountryName(), style);
	            createCell(row, columnCount++, film.getAge(), style);
	            createCell(row, columnCount++, film.getRate(), style);
	            createCell(row, columnCount++, film.isStatus() ? "Đang chiếu" : "Không còn chiếu", style);
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	    }
}
