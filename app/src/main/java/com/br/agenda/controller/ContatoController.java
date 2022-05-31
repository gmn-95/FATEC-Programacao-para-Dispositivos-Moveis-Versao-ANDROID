package com.br.agenda.controller;

import android.content.Context;

import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Contato;
import com.br.agenda.model.dao.AgendamentoDAO;
import com.br.agenda.model.dao.ContatoDAO;
import com.br.agenda.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class ContatoController {

    private ContatoDAO contatoDAO;
    private DBHelper dbHelper;

    public ContatoController(Context context) throws SQLException {
        dbHelper = new DBHelper(context);
        contatoDAO = new ContatoDAO(dbHelper.getConnectionSource());
    }

    public void inserir(Contato contato) throws SQLException {
        contatoDAO.create(contato);
    }

    public void excluir(Integer id) throws SQLException {
        contatoDAO.deleteById(id);
    }

    public Contato buscar(Integer id) throws SQLException {
        return contatoDAO.queryForId(id);
    }

    public List<Contato> listarContatos(Contato contato) throws SQLException {
        List<Contato> contatoList = contatoDAO.queryForMatching(contato);

        if(contatoList.isEmpty() || contato == null){
            return null;
        }
        return contatoList;
    }

}
