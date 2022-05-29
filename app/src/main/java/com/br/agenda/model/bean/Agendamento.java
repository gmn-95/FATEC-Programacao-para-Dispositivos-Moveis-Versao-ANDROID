package com.br.agenda.model.bean;

import android.renderscript.Element;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@DatabaseTable(tableName = "agendamento")
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId = true, columnName = "idAgendamento")
    private Integer id;

    @DatabaseField(foreign = true, foreignColumnName = "idContato", canBeNull = false)
    private Contato contato;

    @DatabaseField(foreign = true, foreignColumnName = "idUsuario", canBeNull = false)
    private Usuario usuario;

    @DatabaseField(dataType = DataType.DATE_STRING, canBeNull = false)
    private Date data_agendada;

    @DatabaseField(dataType = DataType.DATE_STRING, canBeNull = false)
    private Date hora_agendada;

    @DatabaseField(columnName = "descricao")
    private String descricao;

    @DatabaseField(columnName = "conteudo")
    private String conteudo;

    public Agendamento() {
    }

    public Agendamento(Usuario usuario) {
        this.usuario = usuario;
    }

    public Agendamento(Integer id, Contato contato, Usuario usuario, Date data_agendada, Date hora_agendada, String descricao, String conteudo) {
        this.id = id;
        this.contato = contato;
        this.usuario = usuario;
        this.data_agendada = data_agendada;
        this.hora_agendada = hora_agendada;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Agendamento(Contato contato, Usuario usuario, Date data_agendada, Date hora_agendada, String descricao, String conteudo) {
        this.contato = contato;
        this.usuario = usuario;
        this.data_agendada = data_agendada;
        this.hora_agendada = hora_agendada;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Agendamento(Contato contato, Usuario usuario) {
        this.contato = contato;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(Date data_agendada) {
        this.data_agendada = data_agendada;
    }

    public Date getHora_agendada() {
        return hora_agendada;
    }

    public void setHora_agendada(Date hora_agendada) {
        this.hora_agendada = hora_agendada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agendamento)) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getContato(), that.getContato()) && Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getData_agendada(), that.getData_agendada()) && Objects.equals(getHora_agendada(), that.getHora_agendada()) && Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getConteudo(), that.getConteudo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContato(), getUsuario(), getData_agendada(), getHora_agendada(), getDescricao(), getConteudo());
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", contato=" + contato +
                ", usuario=" + usuario +
                ", data_agendada=" + data_agendada +
                ", hora_agendada=" + hora_agendada +
                ", descricao='" + descricao + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
