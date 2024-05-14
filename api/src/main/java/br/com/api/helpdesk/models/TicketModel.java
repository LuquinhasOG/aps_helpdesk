package br.com.api.helpdesk.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTicket; // chave primaria

    @ManyToOne
    @JoinColumn(name = "id_usuario_abertura")
    private UsuarioModel usuarioAbertura; // chave estrangeira para id_usuario, cardinalidade muitos tickets para um usuário

    @ManyToOne
    @JoinColumn(name = "id_estado_ticket")
    private EstadoTicketModel estadoTicket; // chave estrangeira para id_estado_ticket, cardinalidade muitos tickets para um estado

    @Column(name = "data_abertura")
    private Timestamp dataAbertura;

    @Column(name = "data_fechamento")
    private Timestamp dataFechamento;

    @Column(length = 150)
    private String titulo;

    @Column(length = 2000)
    private String descricao;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public UsuarioAberturaTicketModel getUsuarioAbertura() {
        UsuarioAberturaTicketModel modeloUsuarioAbertura = new UsuarioAberturaTicketModel();
        modeloUsuarioAbertura.setIdUsuario(usuarioAbertura.getIdUsuario());
        modeloUsuarioAbertura.setNome(usuarioAbertura.getNome());
        modeloUsuarioAbertura.setEmail(usuarioAbertura.getEmail());
        modeloUsuarioAbertura.setNivelPermissao(usuarioAbertura.getNivelPermissao());

        return modeloUsuarioAbertura;
    }

    public void setUsuarioAbertura(UsuarioModel usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    public EstadoTicketModel getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(EstadoTicketModel estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Timestamp getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Timestamp dataFechamento) {
        this.dataFechamento = dataFechamento;
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
}
