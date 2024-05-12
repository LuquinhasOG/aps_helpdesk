package br.com.api.helpdesk.models;

import org.springframework.stereotype.Component;

@Component
public class UsuarioAberturaTicketModel {
    private String nome;
    private String email;
    private int nivelPermissao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(int nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }
}
