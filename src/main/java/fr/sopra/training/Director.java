package fr.sopra.training;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class Director {
	
	private int id;
	private String firstName;
	private String lastName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Director> getDirectorsFromSession(@Context HttpServletRequest req, List<Director> directors){
		List <Director> list = (List<Director>) req.getSession().getAttribute("realisators");
		if(list==null){
			list = directors;
			req.getSession().setAttribute("realisators", list);
		}
		return list;	
	}

}
