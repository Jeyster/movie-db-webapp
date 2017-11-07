package fr.sopra.training;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class Studio {
	private int id;
	private String name;
	private Date creationDate;
	
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<Studio> getStudiosFromSession(@Context HttpServletRequest req, List<Studio> studios){
		List <Studio> list = (List<Studio>) req.getSession().getAttribute("studios");
		if(list==null){
			list = studios;
			req.getSession().setAttribute("studios", list);
		}
		return list;	
	}
	
}