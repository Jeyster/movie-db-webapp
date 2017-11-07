package fr.sopra.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("movie-db")
public class MovieDBWebServices{
	
	private static List<Studio> studios = new ArrayList<>();
	private static List<Movie> movies = new ArrayList<>();
	private static List<Director> directors = new ArrayList<>();
	private static List<Actor> actors = new ArrayList<>();
	
	private static Studio studio1 = new Studio();
	private static Movie movie1 = new Movie();
	private static Director realisator1 = new Director();
	private static Actor actor1 = new Actor();
		
	static {
		studio1.setId(1);
		studio1.setName("Poliwood");
		studio1.setCreationDate(new Date());
		studios.add(studio1);
		
		realisator1.setId(1);
		realisator1.setFirstName("Mat");
		realisator1.setLastName("Pogora");
		directors.add(realisator1);
		
		actor1.setId(1);
		actor1.setFirstName("Mathieu");
		actor1.setLastName("Gaurat");
		actors.add(actor1);
		
		movie1.setId(1);
		movie1.setName("Super Film");
		movie1.setReleaseDate(new Date());
		movie1.setStudio(studio1);
		movie1.setDirector(realisator1);
		movie1.setActors(actors);
		movies.add(movie1);
		
	}
	
	@GET
	@Path("/movies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies(@Context HttpServletRequest req){
		return this.movie1.getMoviesFromSession(req, movies);
	}
	
	
	@GET
	@Path("/movies/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieFromSession(@PathParam("id") int id, @Context HttpServletRequest req){
		return this.movie1.getMovieFromSession(id, req, this.movies);
	}
	
	@GET
	@Path("/movies/{id}/studio")
	@Produces(MediaType.APPLICATION_JSON)
	public Studio getStudioMovie(@PathParam("id") int id, @Context HttpServletRequest req){
		return this.movie1.getMovieFromSession(id, req, this.movies).getStudio();
	}
	
	@GET
	@Path("/movies/{id}/director")
	@Produces(MediaType.APPLICATION_JSON)
	public Director getRealisatorMovie(@PathParam("id") int id, @Context HttpServletRequest req){
		return this.movie1.getMovieFromSession(id, req, this.movies).getDirector();
	}
	
	@GET
	@Path("/movies/{id}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActorsMovie(@PathParam("id") int id, @Context HttpServletRequest req){
		return this.movie1.getMovieFromSession(id, req, this.movies).getActors();
	}
	
	
	@GET
	@Path("/studios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Studio> getStudios(@Context HttpServletRequest req){
		return this.movie1.getStudio().getStudiosFromSession(req, this.studios);
	}
	
	@GET
	@Path("/directors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Director> getDirectors(@Context HttpServletRequest req){
		return this.movie1.getDirector().getDirectorsFromSession(req, this.directors);
	}
	
	@GET
	@Path("/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActors(@Context HttpServletRequest req){
		List <Actor> list = (List<Actor>) req.getSession().getAttribute("actors");
		if(list==null){
			list = this.actors;
			req.getSession().setAttribute("actors", list);
		}
		return list;	
	}
	
	@POST
	@Path("/movies")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Movie addMovie(@Context HttpServletRequest req, Movie movie){
		return this.movie1.addMovieFromSession(req, movie);
	}

	
}
