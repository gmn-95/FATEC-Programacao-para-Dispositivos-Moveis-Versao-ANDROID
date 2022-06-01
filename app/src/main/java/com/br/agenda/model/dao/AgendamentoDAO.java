package com.br.agenda.model.dao;

import com.br.agenda.model.bean.Agendamento;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class AgendamentoDAO extends BaseDaoImpl<Agendamento, Integer> {
    public AgendamentoDAO(ConnectionSource cs) throws SQLException {
        super(Agendamento.class);
        setConnectionSource(cs);
        initialize();
    }
}
