package br.com.api.helpdesk.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "comentarios")
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComentario;

    @Column(name = "conteudo_comentario")
    private String conteudoComentario;

    @Column(name = "data_publicacao")
    private Timestamp dataPublicacao;

    @Column(name = "id_ticket_comentario")
    private int idTicketComentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario_comentario")
    private UsuarioModel usuarioComentario;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

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

    public UsuarioAberturaTicketModel getUsuarioComentario() {
        UsuarioAberturaTicketModel usuario = new UsuarioAberturaTicketModel();
        usuario.setNome(usuarioComentario.getNome());
        usuario.setIdUsuario(0);
        usuario.setNivelPermissao(usuarioComentario.getNivelPermissao());
        usuario.setEmail("");

        return usuario;
    }

    public void setUsuarioComentario(UsuarioModel usuarioComentario) {
        this.usuarioComentario = usuarioComentario;
    }
}
