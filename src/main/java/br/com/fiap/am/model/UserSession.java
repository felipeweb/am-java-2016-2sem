package br.com.fiap.am.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
