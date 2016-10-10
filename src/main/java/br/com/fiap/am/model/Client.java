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
	protected Client(){
		this(null, null, null);
	}
	
	public Client(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.COMPRADOR);
	}

	@Override
	public String getRg() {
		return rg;
	}

	@Override
	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String getCpf() {
		return cpf;
	}

	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getFaixaInvestimento() {
		return null;
	}

	@Override
	public void setFaixaInvestimento(double faixaInvestimento) {

	}

	@Override
	public String getTempoInvestimento() {
		return null;
	}

	@Override
	public void setTempoInvestimento(int tempoInvestimento) {

	}

	@Override
	public String getParticipacao() {
		return null;
	}

	@Override
	public String getProfissao() {
		return profissao;
	}

	@Override
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String getEstadoCivil() {
		return estadoCivil;
	}

	@Override
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String getFaixaSalarial() {
		return faixaSalarial;
	}

	@Override
	public void setFaixaSalarial(String faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
}
