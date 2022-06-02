package com.br.agenda.util;

import android.content.Context;

import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.controller.UsuarioController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;

import java.sql.SQLException;
import java.text.ParseException;

public class PovoaBanco {

    public static void criarUsuario(Context context) throws SQLException {
        Usuario usuario = new Usuario("Gustavo","admin", "admin");
        UsuarioController usuarioController = new UsuarioController(context);
        usuarioController.inserir(usuario);
    }

    public static void criarAgendamento(Context context) throws SQLException, ParseException {
        Usuario usuario = new Usuario(1);

        Agendamento agendamento = new Agendamento(1, usuario, "10-06-2022", "19:00",
                "Aniversário", "Meu aniversário");

        AgendamentoController agendamentoController = new AgendamentoController(context);
        agendamentoController.inserir(agendamento);
    }

}
