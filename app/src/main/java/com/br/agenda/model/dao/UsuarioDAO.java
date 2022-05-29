package com.br.agenda.model.dao;

import com.br.agenda.model.bean.Usuario;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class UsuarioDAO extends BaseDaoImpl<Usuario, Integer> {

    public UsuarioDAO(ConnectionSource cs) throws SQLException{
        super(Usuario.class);
        setConnectionSource(cs);
        initialize();
    }

}
