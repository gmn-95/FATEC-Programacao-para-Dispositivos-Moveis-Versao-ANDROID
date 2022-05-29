package com.br.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;
import com.br.agenda.model.dao.AgendamentoDAO;

import java.sql.SQLException;
import java.util.List;

public class ViewAgendamentos extends AppCompatActivity {
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);

        try {
            Usuario usuario = getIntent().getParcelableExtra("user");

            Agendamento agendamento = new Agendamento(usuario);
            AgendamentoController agendamentoController = new AgendamentoController(ViewAgendamentos.this);

            List<Agendamento> agendamentoList = agendamentoController.listarAgendamentos(agendamento);

            if(agendamentoList != null){
                for (Agendamento age : agendamentoList){
                    System.out.println(age);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}