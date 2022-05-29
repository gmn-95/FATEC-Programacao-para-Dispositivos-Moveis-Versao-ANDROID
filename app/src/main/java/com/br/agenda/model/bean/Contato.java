package com.br.agenda.model.bean;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId = true, columnName = "idContato")
    private Integer id;

    @DatabaseField(foreign = true, foreignColumnName = "idUsuario", canBeNull = false)
    private Usuario usuario;

    @DatabaseField(columnName = "nome", canBeNull = false)
    private String nome;

    @DatabaseField(columnName = "telFixo")
    private String telefone_fixo;

    @DatabaseField(columnName = "celular")
    private String celular;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "obs")
    private String obs;

    public Contato() {
    }

    public Contato(Integer id, Usuario usuario, String nome, String telefone_fixo, String celular, String email, String obs) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.email = email;
        this.obs = obs;
    }

    public Contato(Usuario usuario, String nome, String telefone_fixo, String celular, String email, String obs) {
        this.usuario = usuario;
        this.nome = nome;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.email = email;
        this.obs = obs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getId(), contato.getId()) && Objects.equals(getUsuario(), contato.getUsuario()) && Objects.equals(getNome(), contato.getNome()) && Objects.equals(getTelefone_fixo(), contato.getTelefone_fixo()) && Objects.equals(getCelular(), contato.getCelular()) && Objects.equals(getEmail(), contato.getEmail()) && Objects.equals(getObs(), contato.getObs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getNome(), getTelefone_fixo(), getCelular(), getEmail(), getObs());
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", nome='" + nome + '\'' +
                ", telefone_fixo='" + telefone_fixo + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", obs='" + obs + '\'' +
                '}';
    }
}
