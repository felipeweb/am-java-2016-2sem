package br.com.fiap.am.model;

import br.com.fiap.am.enums.AccessLevel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@SerializedName("id")
	private Long id;

	@NotNull
	@NotEmpty
	@SerializedName("nome")
	private String name;

	@NotNull
	@NotEmpty
	@SerializedName("email")
	private String login;

	@NotNull
	@NotEmpty
	@SerializedName("senha")
	private String password;

	@NotNull
	@Enumerated(STRING)
	private AccessLevel accessLevel;

	/**
	 * @deprecated JPA eyes only
	 */
	protected User() {
		this(null, null, null, null);
	}

	public User(String name, String login, String password, AccessLevel accessLevel) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public boolean isAdmin(){
		return accessLevel == AccessLevel.ADMINISTRADOR || accessLevel == AccessLevel.WEBMASTER;
	}
}
