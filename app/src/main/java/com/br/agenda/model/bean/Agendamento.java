package com.br.agenda.model.bean;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.renderscript.Element;

import androidx.annotation.RequiresApi;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@DatabaseTable(tableName = "agendamento")
public class Agendamento implements Serializable, Parcelable {

    private static final long serialVersionUID = 3L;

    @DatabaseField(generatedId = true, columnName = "idAgendamento")
    private Integer id;

    @DatabaseField(foreign = true, foreignColumnName = "idUsuario", canBeNull = false,
        foreignAutoRefresh = true,
            columnDefinition = "INTEGER REFERENCES usuario(idUsuario) on delete cascade on update cascade")
    private Usuario usuario;

    @DatabaseField(canBeNull = false)
    private String data_agendada;

    @DatabaseField(canBeNull = false)
    private String hora_agendada;

    @DatabaseField(columnName = "descricao")
    private String descricao;

    @DatabaseField(columnName = "conteudo")
    private String conteudo;

    public Agendamento() {
    }

    public Agendamento(Integer id, Usuario usuario, String data_agendada, String hora_agendada, String descricao, String conteudo) {
        this.id = id;
        this.usuario = usuario;
        this.data_agendada = data_agendada;
        this.hora_agendada = hora_agendada;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Agendamento(Usuario usuario, String data_agendada, String hora_agendada, String descricao, String conteudo) {
        this.usuario = usuario;
        this.data_agendada = data_agendada;
        this.hora_agendada = hora_agendada;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Agendamento(Usuario usuario) {
        this.usuario = usuario;
    }

    protected Agendamento(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        usuario = in.readParcelable(Usuario.class.getClassLoader());
        descricao = in.readString();
        conteudo = in.readString();
    }

    public static final Creator<Agendamento> CREATOR = new Creator<Agendamento>() {
        @Override
        public Agendamento createFromParcel(Parcel in) {
            return new Agendamento(in);
        }

        @Override
        public Agendamento[] newArray(int size) {
            return new Agendamento[size];
        }
    };

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

    public String getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(String data_agendada) {
        this.data_agendada = data_agendada;
    }

    public String getHora_agendada() {
        return hora_agendada;
    }

    public void setHora_agendada(String hora_agendada) {
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
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getData_agendada(), that.getData_agendada()) && Objects.equals(getHora_agendada(), that.getHora_agendada()) && Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getConteudo(), that.getConteudo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getData_agendada(), getHora_agendada(), getDescricao(), getConteudo());
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", data_agendada=" + data_agendada +
                ", hora_agendada=" + hora_agendada +
                ", descricao='" + descricao + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeParcelable(usuario, flags);
        dest.writeString(descricao);
        dest.writeString(conteudo);
        dest.writeString(data_agendada);
        dest.writeString(hora_agendada);
    }
}
