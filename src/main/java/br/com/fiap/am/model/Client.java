package br.com.fiap.am.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import br.com.caelum.stella.bean.validation.CPF;
import br.com.fiap.am.enums.AccessLevel;

@Entity
@DiscriminatorValue("client")
public class Client extends User {

	@NotNull
	private String rg;
	@NotNull
	@CPF
	private String cpf;
	@NotNull
	private String phone;
	private String profissao;
	private String estadoCivil;
	private String faixaSalarial;

	/**
	 * @deprecated JPA eyes only
	 */
	protected Client() {
		this(null, null, null);
	}

	public Client(String nome, String login, String senha) {
		super(nome, login, senha, AccessLevel.COMPRADOR);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFaixaSalarial() {
		return faixaSalarial;
	}

	public void setFaixaSalarial(String faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
}
