package br.com.fiap.am.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CPF;
import br.com.fiap.am.enums.AccessLevel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("investor")
public class Investor extends User {

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
    @OneToMany(cascade = CascadeType.ALL)
    private List<QuantidadePorPacote> quantidadePackage;

    /**
     * @deprecated JPA eyes only
     */
    protected Investor() {
        this(null, null, null);
    }

    public Investor(String nome, String login, String senha) {
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


    public List<QuantidadePorPacote> getQuantidadePackage() {
        return quantidadePackage;
    }

    public void setQuantidadePackage(List<QuantidadePorPacote> quantidadePackage) {
        this.quantidadePackage = quantidadePackage;
    }

    public Double getSubTotal() {
        return quantidadePackage.stream().mapToDouble(q -> q.getInvestPackage().getValor().doubleValue()).sum();
    }

    public String getSubTotalf() {
        DecimalFormat decimalFormat = new DecimalFormat("0");

        return decimalFormat.format(quantidadePackage.stream().mapToDouble(q -> q.getInvestPackage().getValor().doubleValue()).sum());
    }
}
