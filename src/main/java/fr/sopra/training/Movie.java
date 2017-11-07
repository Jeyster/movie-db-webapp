package fr.sopra.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {

	private Integer id;
	private String name;
	private Date releaseDate;
	private Studio studio;
	private Realisator realisator;
	private List<Actor> actors;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Realisator getRealisator() {
		return realisator;
	}
	public void setRealisator(Realisator realisator) {
		this.realisator = realisator;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
