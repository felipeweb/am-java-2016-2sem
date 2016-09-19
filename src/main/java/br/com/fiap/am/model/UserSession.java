package br.com.fiap.am.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class UserSession implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public void add(User user){
		this.user = user;
	}
	
	public void invalidate(){
		this.user = null;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public boolean isLogged(){
		return user != null;
	}
}
