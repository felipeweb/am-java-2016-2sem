package br.com.fiap.am.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CPF;
import br.com.fiap.am.enums.AccessLevel;

@Entity
@DiscriminatorValue("investor")
public class Investor extends User{
	
	@NotNull
	private String rg;
	@NotNull
	@CPF
	private String cpf;
	@NotNull
	private String phone;
	private String faixaInvestimento;
	private String tempoInvestimento;
	private String participacao;
	
	/**
	 * @deprecated JPA eyes only
	 */
	protected Investor(){
		this(null, null, null);
	}
	
	public Investor(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.INVESTIDOR);
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

	public String getFaixaInvestimento() {
		return faixaInvestimento;
	}

	public void setFaixaInvestimento(String faixaInvestimento) {
		this.faixaInvestimento = faixaInvestimento;
	}

	public String getTempoInvestimento() {
		return tempoInvestimento;
	}

	public void setTempoInvestimento(String tempoInvestimento) {
		this.tempoInvestimento = tempoInvestimento;
	}

	public String getParticipacao() {
		return participacao;
	}

	public void setParticipacao(String participacao) {
		this.participacao = participacao;
	}
}
