package br.com.api.helpdesk.models;

import jakarta.persistence.*;

import java.io.Serial;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "patrimonio")
public class PatrimonioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPatrimonio;
    private String nomePatrimonio;
    private BigDecimal preco;
    private int quantidade;
    private String descricao;
    private Date dataCriacao;
    private int idUsuario;

    public UUID getIdPatrimonio() {
        return idPatrimonio;
    }

    public void setIdPatrimonio(UUID idPatrimonio) {
        this.idPatrimonio = idPatrimonio;
    }

    public String getNomePatrimonio() {
        return nomePatrimonio;
    }

    public void setNomePatrimonio(String nomePatrimonio) {
        this.nomePatrimonio = nomePatrimonio;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}