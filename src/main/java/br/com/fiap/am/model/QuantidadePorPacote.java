package br.com.fiap.am.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
public class QuantidadePorPacote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @NotNull
    private InvestPackage investPackage;
    @NotNull
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvestPackage getInvestPackage() {
        return investPackage;
    }

    public void setInvestPackage(InvestPackage investPackage) {
        this.investPackage = investPackage;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return investPackage.getValor().multiply(new BigDecimal(quantidade)).doubleValue();
    }

    public String getTotalf() {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        return decimalFormat.format(investPackage.getValor().multiply(new BigDecimal(quantidade)).doubleValue());
    }
}
