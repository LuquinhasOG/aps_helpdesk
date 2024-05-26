package br.com.api.helpdesk.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadotickets")
public class EstadoTicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estado_ticket")
    private int idEstadoTicket; // chave primária

    @Column(nullable = false, length = 40)
    private String descricao;

    public int getIdEstadoTicket() {
        return idEstadoTicket;
    }

    public void setIdEstadoTicket(int idEstadoTicket) {
        this.idEstadoTicket = idEstadoTicket;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
