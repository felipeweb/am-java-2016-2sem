package br.com.fiap.am.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.fiap.am.enums.AccessLevel;

@Entity
@DiscriminatorValue("webmaster")
public class Webmaster extends User{
	
	/**
	 * @deprecated JPA eyes only
	 */
	protected Webmaster(){
		this(null, null, null);
	}
	
	public Webmaster(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.WEBMASTER);
	}	
}
