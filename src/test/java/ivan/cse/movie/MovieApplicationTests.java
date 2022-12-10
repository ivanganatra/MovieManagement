package ivan.cse.movie;

import ivan.cse.movie.model.City;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.repo.CityRepository;
import ivan.cse.movie.repo.MovieRepository;
import ivan.cse.movie.repo.TheatreRepository;
import ivan.cse.movie.service.MovieServices;
import ivan.cse.movie.serviceImpl.CityServicesImpl;
import ivan.cse.movie.serviceImpl.MovieServicesImpl;
import ivan.cse.movie.serviceImpl.TheatreServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieApplicationTests {

	@Test
	public void contextLoads() {
	}
	@MockBean
	private MovieRepository movieRepository;
	@MockBean
	private CityRepository cityRepository;

	@Autowired
	private MovieServicesImpl movieServices;

	@Autowired
	private CityServicesImpl cityServices;

	@Test
	public void getAllMoviesTest(){
		Mockito.when(movieRepository.findAll()).thenReturn(Stream
				.of(new Movie(Long.valueOf(1),"testmovie","testgenre",Long.valueOf(1))).collect(Collectors.toList()));
		Assert.assertEquals(1, movieServices.getAllMovies().size());
	}

	@Test
	public void getAllCitiesTest(){
		Mockito.when(cityRepository.findAll()).thenReturn(Stream
				.of(new City(Long.valueOf(1),"test1"), new City(Long.valueOf(2),"test2")).collect(Collectors.toList()));
		Assert.assertEquals(2, cityServices.getAllCities().size());
	}

}
