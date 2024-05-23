package br.com.api.helpdesk.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.io.Serial;
import jakarta.persistence.GenerationType;
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
}