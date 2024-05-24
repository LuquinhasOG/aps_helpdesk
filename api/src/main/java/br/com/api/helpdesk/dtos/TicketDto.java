package br.com.api.helpdesk.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.UUID;

public class TicketDto {
    @NotNull
    private int usuarioAbertura;

    @NotNull
    private int estadoTicket;

    @NotNull
    private Timestamp dataAbertura;

    private Timestamp dataFechamento;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    private UUID idPatrimonio;

    public UUID getIdPatrimonio() {
        return idPatrimonio;
    }

    public void setIdPatrimonio(UUID idPatrimonio) {
        this.idPatrimonio = idPatrimonio;
    }

    public int getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(int usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    public int getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(int estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Timestamp dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
}
