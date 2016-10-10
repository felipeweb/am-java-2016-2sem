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

	@Override
	public String getRg() {
		return null;
	}

	@Override
	public void setRg(String rG) {

	}

	@Override
	public String getCpf() {
		return null;
	}

	@Override
	public void setCpf(String cPF) {

	}

	@Override
	public String getPhone() {
		return null;
	}

	@Override
	public void setPhone(String phone) {

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

	public Administrator(String nome, String login, String senha){
		super(nome, login, senha, AccessLevel.ADMINISTRADOR);
	}

}
