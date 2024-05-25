package br.com.api.helpdesk.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;

public class ComentarioDto {
    @NotBlank
    private String conteudoComentario;
    @NotNull
    private Timestamp dataPublicacao;
    @NotNull
    private int idTicketComentario;
    @NotNull
    private int idUsuarioComentario;

    public String getConteudoComentario() {
        return conteudoComentario;
    }

    public void setConteudoComentario(String conteudoComentario) {
        this.conteudoComentario = conteudoComentario;
    }

    public Timestamp getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Timestamp dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getIdTicketComentario() {
        return idTicketComentario;
    }

    public void setIdTicketComentario(int idTicketComentario) {
        this.idTicketComentario = idTicketComentario;
    }

    public int getIdUsuarioComentario() {
        return idUsuarioComentario;
    }

    public void setIdUsuarioComentario(int idUsuarioComentario) {
        this.idUsuarioComentario = idUsuarioComentario;
    }
}
