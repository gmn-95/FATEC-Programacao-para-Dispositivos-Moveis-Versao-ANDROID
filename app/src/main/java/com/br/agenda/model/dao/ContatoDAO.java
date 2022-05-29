package com.br.agenda.model.dao;

import com.br.agenda.model.bean.Contato;
import com.br.agenda.model.bean.Usuario;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class ContatoDAO extends BaseDaoImpl<Contato, Integer> {
    public ContatoDAO(ConnectionSource cs) throws SQLException {
        super(Contato.class);
        setConnectionSource(cs);
        initialize();
    }
}
