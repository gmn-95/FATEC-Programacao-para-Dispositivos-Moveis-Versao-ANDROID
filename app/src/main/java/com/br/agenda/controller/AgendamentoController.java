package com.br.agenda.controller;

import android.content.Context;

import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;
import com.br.agenda.model.dao.AgendamentoDAO;
import com.br.agenda.util.DBHelper;
import com.j256.ormlite.stmt.DeleteBuilder;

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

    public void excluirPorUsuario(Usuario usuario) throws SQLException{
        DeleteBuilder<Agendamento, Integer> deleteBuilder = agendamentoDAO.deleteBuilder();
        deleteBuilder.where().eq("usuario_idusuario", usuario.getId());
        deleteBuilder.delete();

    }

    public void excluirPorId(Integer id) throws SQLException{
        agendamentoDAO.deleteById(id);
    }

    public void atualizar(Agendamento agendamento) throws SQLException {
        agendamentoDAO.update(agendamento);
    }

    public List<Agendamento> listarAgendamentos(Agendamento agendamento) throws SQLException {
        List<Agendamento> agendamentoList = agendamentoDAO.queryForMatching(agendamento);
        return agendamentoList;
    }

    public List<Agendamento> listarTudo() throws SQLException {
        return agendamentoDAO.queryForAll();
    }

}
