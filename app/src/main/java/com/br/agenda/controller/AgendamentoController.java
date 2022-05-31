package com.br.agenda.controller;

import android.content.Context;
import android.content.Intent;

import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Contato;
import com.br.agenda.model.bean.Usuario;
import com.br.agenda.model.dao.AgendamentoDAO;
import com.br.agenda.model.dao.UsuarioDAO;
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

    public void excluir(Integer id) throws SQLException{
        agendamentoDAO.deleteById(id);
    }

    public void atualizar(Agendamento agendamento) throws SQLException {
        agendamentoDAO.update(agendamento);
    }

    public List<Agendamento> listarAgendamentos(Agendamento agendamento) throws SQLException {
        List<Agendamento> agendamentoList = agendamentoDAO.queryForMatching(agendamento);

        if(agendamentoList.isEmpty() || agendamentoList == null){
            return null;
        }
        return agendamentoList;
    }

}
