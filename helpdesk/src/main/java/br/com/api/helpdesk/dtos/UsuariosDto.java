package br.com.api.helpdesk.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class UsuariosDto {
    // essas anotações @NotBlank e @NotNull servem para a API não aceitar valores vazios
    // no caso @NotBlank é usado para verificar Strings, e @NotNull outros objetos como números e datas
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotBlank
    private String email;
    @NotNull
    private Date dataNascimento;
    private Date dataCriacaoUsuario; // aqui não precisa de verificação, pois o dia de criação do usuário será inserido no método de postagem de dados da classe UsuariosControler
    @NotNull
    private int nivelPermissao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCriacaoUsuario() {
        return dataCriacaoUsuario;
    }

    public void setDataCriacaoUsuario(Date dataCriacaoUsuario) {
        this.dataCriacaoUsuario = dataCriacaoUsuario;
    }

    public int getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(int nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }
}
