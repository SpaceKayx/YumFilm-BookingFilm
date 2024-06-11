package com.config.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.entity.Actor;
import com.config.entity.ActorOfFilm;
import com.config.entity.Country;
import com.config.entity.Director;
import com.config.entity.DirectorOfFilm;
import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;
import com.config.entity.FilmDetail;
import com.config.entity.FilmGenres;
import com.config.entity.FilmType;
import com.config.repository.ActorOfFilmRepository;
import com.config.repository.ActorRepository;
import com.config.repository.AdminFimlRepository;
import com.config.repository.CountryRepository;
import com.config.repository.DirectorOfFilmRepository;
import com.config.repository.DirectorRepository;
import com.config.repository.FilmDetailRepository;
import com.config.repository.FilmGenresRepository;
import com.config.repository.FilmRepository;
import com.config.repository.FilmTypeRepository;

import lombok.AllArgsConstructor;

@Service
public class AdminFimlService {
	
	@Autowired
	private AdminFimlRepository repo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	FilmTypeRepository filmTypeRepo;
	
	@Autowired 
	FilmGenresRepository filmGenresRepo;
	
	@Autowired
	DirectorRepository directorRepository;
	
	@Autowired
	DirectorOfFilmRepository dofFilmRepository;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ActorOfFilmRepository aofFilmRepository;
	
	@Autowired
	FilmDetailRepository filmDetailRepository;
	
	@Autowired
	FilmRepository filmRepository;
	public List<Object[]> findAll(){
//		System.out.println(listFilmAdmin());
		return repo.listFilmAdmin();
		
	}
	
	public Film findById(Integer id) {
		return repo.findById(id).get();
	}

	public FilmAdminDetail detailFimlAdmin(int filmId){
		List<Object[]> objs = repo.detailFilmAdmin(filmId);
		Object[] obj = objs.get(0);
		FilmAdminDetail filmAdminDetail = FilmAdminDetail.builder()
				.FilmId(Integer.parseInt(obj[0].toString()))
				.FilmName(obj[1].toString())
				.FilmImage(obj[2].toString())
				.YearProduction((Date)obj[3])
				.FILMTYPES(obj[4].toString())
				.Description(obj[5].toString())
				.FilmTime(obj[6].toString())
				.PremiereDate((Date)obj[7])
				.DirectorName(obj[8].toString())
				.ACTORS(obj[9].toString())
				.CountryId(obj[12].toString())
				.price((double) obj[14])
				.age( (int) obj[13])
				.build();
		return filmAdminDetail;
	}
	
	public  void addFilm( String filmName, Date produtionDate, String filmTime,
			String directorName, String filmType, Date premiereDate ,
			 String countryId, String actorName,  String descriptionFilm,
			String filmImageFilm , double price, int age) {
		try {
			Film film = new Film();
			FilmDetail film_detail = new FilmDetail();
			FilmGenres film_genres = new FilmGenres();
			FilmType film_type = new FilmType();
			Actor actors = new Actor();
			ActorOfFilm actorOfFilm = new ActorOfFilm();
			Country country = new Country();
			Director director =	 new Director();
			DirectorOfFilm directorOfFilm = new DirectorOfFilm();

			if(countryRepo.findById(countryId).isPresent()) {
				country = countryRepo.findById(countryId).get();
			}
			System.out.println(country.getCountryId());
			
			film.setFilmName(filmName);
			film.setFilmTime(filmTime);
			film.setFilmImage(filmImageFilm);
			film.setPremiereDate(premiereDate);
			film.setCountry(country);
			film.setPrice(price);
			film.setAge(age);
			
			System.out.println(1);
			film.setStatus(true);
			repo.save(film);
			
			film_detail.setFilm(film);
			film_detail.setDescription(descriptionFilm);
			film_detail.setProdutionDate(produtionDate);
			film_detail.setStatus(true);
			filmDetailRepository.save(film_detail);
			
//			film_detail = filmDetailRepository.findByFilmId(film.getFilmId()).get();
			if(directorRepository.findByDirectorName(directorName).isPresent()) {
				director = directorRepository.findByDirectorName(directorName).get();
				directorOfFilm.setDirector(director);
				directorOfFilm.setFilmDetail(film_detail);
				dofFilmRepository.save(directorOfFilm);
			}
			else {
				director.setDirectorName(directorName);
				director.setStatus(true);
				directorRepository.save(director);
				
				directorOfFilm.setDirector(director);
				directorOfFilm.setFilmDetail(film_detail);
				dofFilmRepository.save(directorOfFilm);
			}
			
			List<String> listActors = Arrays.stream(actorName.split(","))
	                 .map(String::trim)
	                 .collect(Collectors.toList());
			for(String nameActor : listActors) {

				film_detail = filmDetailRepository.findByFilmId(film.getFilmId()).get();

				if (actorRepository.findByActorName(nameActor).isPresent()) {
		            actors = actorRepository.findByActorName(nameActor).get();
		        } else {
		            actors = new Actor();
		            actors.setActorName(nameActor);
		            actors.setStatus(true);
		            actorRepository.save(actors);
		        }

		        actorOfFilm = new ActorOfFilm();
		        actorOfFilm.setActor(actors);
		        actorOfFilm.setFilmDetail(film_detail);
		        aofFilmRepository.save(actorOfFilm);

				System.out.println(actors.getActorName());
				System.out.println(film_detail.getFilmDetailId());
			}
			
			 List<String> listFilmType = Arrays.stream(filmType.split(","))
	                 .map(String::trim)
	                 .collect(Collectors.toList());
			 for(String filmTypeName : listFilmType) {
				 film_detail = filmDetailRepository.findByFilmId(film.getFilmId()).get();
				 if(filmTypeRepo.findByFilmTypeName(filmTypeName).isPresent()) {
					 film_type = filmTypeRepo.findByFilmTypeName(filmTypeName).get();
					 
				
				 }else {
					 film_type = new FilmType();
					 film_type.setFilmTypeName(filmTypeName);
					 film_type.setStatus(true);
					 filmTypeRepo.save(film_type);	
				
					 
				 }
				 film_genres = new FilmGenres();
				 film_genres.setFilmType(film_type);
				 film_genres.setFilm(film);
				 filmGenresRepo.save(film_genres);
			 }
				 
			 } catch (Exception e) {
			e.printStackTrace();
			 }
		
	}
	
	public void deleteFilm(@PathVariable("filmId") Integer filmId) {
		Film film = filmRepository.findById(filmId).get();
		film.setStatus(false);
		filmRepository.save(film);
		
		}

	public void updateFilm(@PathVariable("filmId") Integer filmId,
			@PathVariable("filmName")String filmName, 
			@PathVariable("productionDate") Date produtionDate,
			@PathVariable("filmTime") String filmTime,
			@PathVariable("directorName") String directorName,
			@PathVariable("FILMTYPES") String filmType, 
			@PathVariable("premiereDate") Date premiereDate ,
			@PathVariable("countryId") String countryId,
			@PathVariable("actorName") String actorName, 
			@PathVariable("descriptionFilm") String descriptionFilm,
			@PathVariable("filmImageFilm") String filmImageFilm , 
			@PathVariable("price") double price, 
			@PathVariable("age") int age) {
		
		Film film = filmRepository.findById(filmId).get();
		System.out.println(film.getFilmId());
		System.out.println(film.getFilmId());
		System.out.println(film.getFilmId());
		System.out.println(film.getFilmId());
		System.out.println(film.getFilmId());
		try {
			
			FilmDetail film_detail = new FilmDetail();
			FilmGenres film_genres = new FilmGenres();
			FilmType film_type = new FilmType();
			Actor actors = new Actor();
			ActorOfFilm actorOfFilm = new ActorOfFilm();
			Country country = new Country();
			Director director =	 new Director();
			DirectorOfFilm directorOfFilm = new DirectorOfFilm();

			System.out.println(countryId);
			if(countryRepo.findById(countryId).isPresent()) {
				country = countryRepo.findById(countryId).get();
			}
			System.out.println(country.getCountryId());
			
			film.setFilmName(filmName);
			film.setFilmTime(filmTime);
			if (filmImageFilm != null) {
				film.setFilmImage(filmImageFilm);
			}else {
				film.setFilmImage(film.getFilmImage());
			}
			film.setPremiereDate(premiereDate);
			film.setCountry(country);
			film.setPrice(price);
			film.setAge(age);
			
			System.out.println(1);
			film.setStatus(true);
			repo.save(film);
			
			film_detail = filmDetailRepository.findByFilmId(film.getFilmId()).get();
			if(filmDetailRepository.findByFilmId(film.getFilmId()).isPresent()) {
				film_detail.setFilmDetailId(film_detail.getFilmDetailId());
				film_detail.setDescription(descriptionFilm);
				film_detail.setProdutionDate(produtionDate);
				film_detail.setStatus(true);
				filmDetailRepository.save(film_detail);
			}else {
				film_detail.setFilm(film);
				film_detail.setDescription(descriptionFilm);
				film_detail.setProdutionDate(produtionDate);
				film_detail.setStatus(true);
				filmDetailRepository.save(film_detail);
			}
			
			
//			film_detail = filmDetailRepository.findByFilmId(film.getFilmId()).get();
			if(directorRepository.findByDirectorName(directorName).isPresent()) {
				director = directorRepository.findByDirectorName(directorName).get();
				film_detail = filmDetailRepository.findById(film_detail.getFilmDetailId()).get();
				
				if(dofFilmRepository
						.findByFilmDetail( 
								film_detail
								.getFilmDetailId())
						.isPresent()) 
				{
					directorOfFilm = dofFilmRepository.findByFilmDetail( film_detail.getFilmDetailId()).get();
					directorOfFilm.setDirectorOfFilmId(directorOfFilm.getDirectorOfFilmId());
					directorOfFilm.setDirector(director);
					directorOfFilm.setFilmDetail(film_detail);
					dofFilmRepository.save(directorOfFilm);
				}else {
					directorOfFilm.setDirector(director);
					directorOfFilm.setFilmDetail(film_detail);
					dofFilmRepository.save(directorOfFilm);
				}
			}
			else {
				director.setDirectorName(directorName);
				director.setStatus(true);
				directorRepository.save(director);
				directorOfFilm.setDirector(director);
				directorOfFilm.setFilmDetail(film_detail);
				dofFilmRepository.save(directorOfFilm);
				
			}
			
			
			if(actorRepository.findByActorName(actorName).isPresent()) {
				actors =  actorRepository.findByActorName(actorName).get();
				film_detail = filmDetailRepository.findById(film_detail.getFilmDetailId()).get();
				
				if(aofFilmRepository.findByFilmDetail( film_detail.getFilmDetailId()).isPresent()) {
					actorOfFilm = aofFilmRepository.findByFilmDetail( film_detail.getFilmDetailId()).get();
					actorOfFilm.setActorOfFilmId(actorOfFilm.getActorOfFilmId());
					actorOfFilm.setActor(actors);
					actorOfFilm.setFilmDetail(film_detail);
					aofFilmRepository.save(actorOfFilm);
				}else {
					actorOfFilm.setActor(actors);
					actorOfFilm.setFilmDetail(film_detail);
					aofFilmRepository.save(actorOfFilm);
				}
				System.out.println(actorOfFilm.getActor().getActorName());
				System.out.println(actorOfFilm.getFilmDetail().getFilm().getFilmName());
			}else {
				
				actors.setActorName(actorName);
				actors.setStatus(true);
				actorRepository.save(actors);	
				
				actorOfFilm.setActor(actors);
				actorOfFilm.setFilmDetail(film_detail);
				aofFilmRepository.save(actorOfFilm);
			}
		
			if(filmTypeRepo.findByFilmTypeName(filmType).isPresent()) {
				film_type = filmTypeRepo.findByFilmTypeName(filmType).get();
				film_genres.setFilmType(film_type);
				film_genres.setFilm(film);
				film_genres = filmGenresRepo.findByFilmTypeAndFilm( film_type.getFilmTypeId(),film.getFilmId()).get();
				
//				if()
				
				filmGenresRepo.save(film_genres);
				System.out.println(film_genres.getFilm().getFilmName());
				System.out.println(film_genres.getFilmType().getFilmTypeName());
				
			}else {
				
				
				film_type.setFilmTypeName(filmType);
				film_type.setStatus(true);
				filmTypeRepo.save(film_type);	
				
				film_genres.setFilmType(film_type);
				film_genres.setFilm(film);
				filmGenresRepo.save(film_genres);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
}
