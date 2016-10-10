package br.com.fiap.am.model;

import br.com.fiap.am.enums.AccessLevel;
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
	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String login;

	@NotNull
	@NotEmpty
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

	public abstract String getRg();

	public abstract void setRg(String rG);

	public abstract String getCpf();

	public abstract void setCpf(String cPF);

	public abstract String getPhone();

	public abstract void setPhone(String phone);

	public abstract String getFaixaInvestimento();

	public abstract void setFaixaInvestimento(double faixaInvestimento);

	public abstract String getTempoInvestimento();

	public abstract void setTempoInvestimento(int tempoInvestimento);

	public abstract String getParticipacao();

	public abstract String getProfissao();

	public abstract void setProfissao(String profissao);

	public abstract String getEstadoCivil();

	public abstract void setEstadoCivil(String estadoCivil);

	public abstract String getFaixaSalarial();

	public abstract void setFaixaSalarial(String faixaSalarial);
}
