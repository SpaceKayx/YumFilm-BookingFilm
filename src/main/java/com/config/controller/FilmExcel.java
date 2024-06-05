package com.config.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.config.entity.Film;
import com.config.service.FilmService;
import com.config.testExcel.FilmExcelExport;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FilmExcel {
	@Autowired
	FilmService filmService;
	
	//Export the list of account to excel
		@GetMapping("/film/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        System.out.println(1);
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        System.out.println(2);

	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=film_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	        System.out.println(3);

	        List<Film> listFilm = filmService.getAll();
	        System.out.println(listFilm.get(0).getFilmName());
	        System.out.println(listFilm.get(0).getCountry().getCountryName());
	        System.out.println(listFilm.get(0).getPremiereDate());
	        System.out.println(4);

	        FilmExcelExport excelExporter = new FilmExcelExport(listFilm);
	         
	        excelExporter.export(response);    
	    }  
}
