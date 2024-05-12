package br.com.api.helpdesk.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*  caso surja um erro aqui, testar se os imports pertencem ao pacote javax
    pois nos tuturiais os pacotes das annotations não pertencem a este pacote jakarta
    exemplo: trocar jakarta.persistence.Entity por javax.persistence.Entity
*/

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario") // anotação para que idUsuario seja a chave primária
    private int idUsuario; // chave primaria

    @Column(nullable = false, length = 255) // anotação para que nome seja um varchar(255) não nulo
    private String nome;

    @Column(nullable = false, length = 255) // anotação para que senha seja um varchar(255) não nulo
    private String senha;

    @Column(nullable = false, length = 255, unique = true) // anotação para que email seja um varchar(255) não nulo e não repetido
    private String email;

    @Column(nullable = false, name = "data_nascimento")
    private Date dataNascimento;

    @Column(nullable = false, name = "data_criacao_usuario")
    private Date dataCriacaoUsuario;

    @Column(nullable = false, name = "nivel_permissao")
    private int nivelPermissao;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

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
