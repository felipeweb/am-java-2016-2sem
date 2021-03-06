package br.com.fiap.am.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by felipeweb on 18/10/16.
 */
@Entity
public class InvestPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String descricao;
    @NotNull
    private Integer quantidade;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Integer quantidadeCompras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public void setQuantidadeCompras(Integer quantidadeCompras) {
        this.quantidadeCompras = quantidadeCompras;
    }
    
    public Integer getQuantidadeDisponivel(){
        Integer v = quantidade - quantidadeCompras;
    	return v >= 0 ? v : 0;
    }

    public Double getSubTotal() {
        BigDecimal total = valor.multiply(new BigDecimal((quantidade - quantidadeCompras)));
        return total.doubleValue();
    }

    public String getSubTotalf() {
        DecimalFormat decimalFormat = new DecimalFormat("0");

        BigDecimal total = valor.multiply(new BigDecimal((quantidade - quantidadeCompras)));
        return decimalFormat.format(total.doubleValue());
    }
}
