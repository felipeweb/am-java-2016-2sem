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
		return faixaInvestimento;
	}

	@Override
	public void setFaixaInvestimento(double faixaInvestimento) {

	}

	public void setFaixaInvestimento(String faixaInvestimento) {
		this.faixaInvestimento = faixaInvestimento;
	}

	@Override
	public String getTempoInvestimento() {
		return tempoInvestimento;
	}

	@Override
	public void setTempoInvestimento(int tempoInvestimento) {

	}

	public void setTempoInvestimento(String tempoInvestimento) {
		this.tempoInvestimento = tempoInvestimento;
	}

	@Override
	public String getParticipacao() {
		return participacao;
	}

	public void setParticipacao(String participacao) {
		this.participacao = participacao;
	}

	@Override
	public String getProfissao() {
		return null;
	}

	@Override
	public void setProfissao(String profissao) {

	}

	@Override
	public String getEstadoCivil() {
		return null;
	}

	@Override
	public void setEstadoCivil(String estadoCivil) {

	}

	@Override
	public String getFaixaSalarial() {
		return null;
	}

	@Override
	public void setFaixaSalarial(String faixaSalarial) {

	}
}
