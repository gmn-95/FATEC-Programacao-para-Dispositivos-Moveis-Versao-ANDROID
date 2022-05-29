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

    public Usuario validaLogin(Usuario usuarioBucado) throws SQLException {
        List<Usuario> usuarioList = usuarioDAO.queryForMatching(usuarioBucado);

        if(usuarioList.isEmpty() || usuarioList == null){
            return null;
        }
        return usuarioList.get(0);
    }


}
