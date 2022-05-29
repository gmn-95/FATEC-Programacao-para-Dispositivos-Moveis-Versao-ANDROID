package com.br.agenda.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Objects;

@DatabaseTable(tableName="usuario")
public class Usuario implements Serializable, Parcelable {

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId = true, columnName = "idUsuario")
    private Integer id;

    @DatabaseField(columnName = "nome", canBeNull = false)
    private String nome;

    @DatabaseField(columnName = "login", unique = true, canBeNull = false)
    private String login;

    @DatabaseField(columnName = "senha", canBeNull = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    protected Usuario(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nome = in.readString();
        login = in.readString();
        senha = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getLogin(), usuario.getLogin()) && Objects.equals(getSenha(), usuario.getSenha());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getLogin(), getSenha());
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
        dest.writeString(nome);
        dest.writeString(login);
        dest.writeString(senha);
    }
}
