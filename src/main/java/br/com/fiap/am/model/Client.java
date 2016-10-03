package br.com.fiap.am.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import br.com.caelum.stella.bean.validation.CPF;
import br.com.fiap.am.enums.AccessLevel;

@Entity
@DiscriminatorValue("client")
public class Client extends User{
	
	@NotNull
	private String RG;
	@NotNull
	@CPF
	private String CPF;
	@NotNull
	private int phone;
	private String profissao;
	private String estadoCivil;
	private double faixaSalarial;
	
	/**
	 * @deprecated JPA eyes only
	 */
	protected Client(){
		this(null, null, null);
	}
	
	public Client(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.COMPRADOR);
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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

	public double getFaixaSalarial() {
		return faixaSalarial;
	}

	public void setFaixaSalarial(double faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
	
	
}
