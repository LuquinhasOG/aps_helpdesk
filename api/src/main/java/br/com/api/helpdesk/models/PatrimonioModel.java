package br.com.api.helpdesk.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.io.Serial;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}