package fr.sopra.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("movie-db")
public class MovieDBWebServices{
	
	private static List<Studio> studios = new ArrayList<>();
	private static List<Movie> movies = new ArrayList<>();
	private static List<Realisator> realisators = new ArrayList<>();
	private static List<Actor> actors = new ArrayList<>();
	
	private static Studio studio1 = new Studio();
	private static Movie movie1 = new Movie();
	private static Realisator realisator1 = new Realisator();
	private static Actor actor1 = new Actor();
		
	static {
		studio1.setId(1);
		studio1.setName("Poliwood");
		studio1.setCreationDate(new Date());
		studios.add(studio1);
		
		realisator1.setId(1);
		realisator1.setFirstName("Mat");
		realisator1.setLastName("Pogora");
		
		actor1.setId(1);
		actor1.setFirstName("Mathieu");
		actor1.setLastName("Gaurat");
		actors.add(actor1);
		
		movie1.setId(1);
		movie1.setName("Super Film");
		movie1.setReleaseDate(new Date());
		movie1.setStudio(studio1);
		movie1.setRealisator(realisator1);
		movie1.setActors(actors);
		movies.add(movie1);
		
	}
	
	@GET
	@Path("/movies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies(@Context HttpServletRequest req){
		List <Movie> list = getSessionMovies(req);
		return list;
	}
	
	
	public static List<Movie> getSessionMovies(HttpServletRequest req){
		List<Movie> list = (List<Movie>) req.getSession().getAttribute("movies");
		if(list==null){
			list = movies;
			req.getSession().setAttribute("movies", list);
		}
		return list;
	}

	
}
