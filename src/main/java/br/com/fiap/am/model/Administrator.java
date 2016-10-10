package br.com.fiap.am.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.fiap.am.enums.AccessLevel;

@Entity
@DiscriminatorValue("administrator")
public class Administrator extends User {

	/**
	 * @deprecated JPA eyes only
	 */
	protected Administrator(){
		this(null, null, null);
	}

	public Administrator(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.ADMINISTRADOR);
	}

}
