package com.br.agenda.controller;

import android.content.Context;

import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.dao.AgendamentoDAO;
import com.br.agenda.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class AgendamentoController {

    private AgendamentoDAO agendamentoDAO;
    private DBHelper dbHelper;

    public AgendamentoController(Context context) throws SQLException {
        dbHelper = new DBHelper(context);
        agendamentoDAO = new AgendamentoDAO(dbHelper.getConnectionSource());
    }

    public void inserir(Agendamento agendamento) throws SQLException {
        agendamentoDAO.create(agendamento);
    }

    public void excluir(Agendamento agendamento) throws SQLException{
        agendamentoDAO.delete(agendamento);
    }

    public void atualizar(Agendamento agendamento) throws SQLException {
        agendamentoDAO.update(agendamento);
    }

    public List<Agendamento> listarAgendamentos(Agendamento agendamento) throws SQLException {
        List<Agendamento> agendamentoList = agendamentoDAO.queryForMatching(agendamento);

        return agendamentoList.isEmpty() || agendamentoList == null ? null : agendamentoList;
    }

}
