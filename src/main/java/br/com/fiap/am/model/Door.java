package br.com.fiap.am.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by felipeweb on 09/10/16.
 */
@Entity
@Table(name = "doors")
public class Door implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SerializedName("id")
    private Long id;
    @NotNull
    @SerializedName("nome")
    private String nome;
    @NotNull
    @SerializedName("status")
    private boolean aberta;
    @NotNull
    @OneToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
