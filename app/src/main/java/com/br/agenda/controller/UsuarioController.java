package com.br.agenda.controller;

import android.content.Context;

import com.br.agenda.model.bean.Usuario;
import com.br.agenda.model.dao.UsuarioDAO;
import com.br.agenda.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private DBHelper dbHelper;

    public UsuarioController(Context context) throws SQLException {
        dbHelper = new DBHelper(context);
        usuarioDAO = new UsuarioDAO(dbHelper.getConnectionSource());
    }

    public void inserir(Usuario usuario) throws SQLException {
        usuarioDAO.create(usuario);
    }

    public void excluirPorId(Integer id) throws SQLException{
        usuarioDAO.deleteById(id);
    }

    public void excluir(Usuario usuario) throws SQLException{
        usuarioDAO.delete(usuario);
    }

    public void atualiza(Usuario usuario) throws SQLException{
        usuarioDAO.update(usuario);
    }

    public Usuario validaLogin(Usuario usuarioBucado) throws SQLException {
        List<Usuario> usuarioList = usuarioDAO.queryForMatching(usuarioBucado);
        return usuarioList.isEmpty() || usuarioList == null ? null : usuarioList.get(0);
    }
}
