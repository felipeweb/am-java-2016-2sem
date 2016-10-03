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
	private String RG;
	@NotNull
	@CPF
	private String CPF;
	@NotNull
	private int phone;
	private double faixaInvestimento;
	private int tempoInvestimento;
	private int participacao;
	
	/**
	 * @deprecated JPA eyes only
	 */
	protected Investor(){
		this(null, null, null);
	}
	
	public Investor(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.INVESTIDOR);
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

	public double getFaixaInvestimento() {
		return faixaInvestimento;
	}

	public void setFaixaInvestimento(double faixaInvestimento) {
		this.faixaInvestimento = faixaInvestimento;
	}

	public int getTempoInvestimento() {
		return tempoInvestimento;
	}

	public void setTempoInvestimento(int tempoInvestimento) {
		this.tempoInvestimento = tempoInvestimento;
	}

	public int getParticipacao() {
		return participacao;
	}

	public void setParticipacao(int participacao) {
		this.participacao = participacao;
	}
	
}
