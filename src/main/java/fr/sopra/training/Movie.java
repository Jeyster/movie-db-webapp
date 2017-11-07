package fr.sopra.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class Movie {

	private int id;
	private String name;
	private Date releaseDate;
	private Studio studio;
	private Director director;
	private List<Actor> actors;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Studio getStudio() {
		return studio;
	}
	public void setStudio(Studio studio) {
		this.studio = studio;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public List<Movie> getMoviesFromSession(@Context HttpServletRequest req, List<Movie> movies){
		List <Movie> list = (List<Movie>) req.getSession().getAttribute("movies");
		if(list==null){
			list = movies;
			req.getSession().setAttribute("movies", list);
		}
		return list;	
	}
	
	public Movie getMovieFromSession(int id,@Context  HttpServletRequest req){
		List<Movie> list = (List<Movie>) req.getSession().getAttribute("movies");
		Movie movie = new Movie();
		if(list==null){
			list = new ArrayList<>();
			req.getSession().setAttribute("movies", list);
		}
		for (int i = 0; i < list.size(); i++) {
			Movie current = list.get(i);
			if (current.getId() == id) {
				movie = current;
			}
		}
		return movie;	
	}
	public Movie getMovieFromSession(int id,@Context  HttpServletRequest req, List<Movie> movies){
		List<Movie> list = (List<Movie>) req.getSession().getAttribute("movies");
		Movie movie = new Movie();
		if(list==null){
			list = movies;
			req.getSession().setAttribute("movies", list);
		}
		for (int i = 0; i < list.size(); i++) {
			Movie current = list.get(i);
			if (current.getId() == id) {
				movie = current;
			}
		}
		return movie;	
	}
	
	public Movie addMovieFromSession(@Context HttpServletRequest req, Movie movie) {
		List<Movie> list = (List<Movie>) req.getSession().getAttribute("movies");
		if (list == null) {
			list = new ArrayList<>();
			req.getSession().setAttribute("movies", list);
		}
		list.add(movie);
		req.getSession().setAttribute("movies", list);
		return movie;
	}
}
