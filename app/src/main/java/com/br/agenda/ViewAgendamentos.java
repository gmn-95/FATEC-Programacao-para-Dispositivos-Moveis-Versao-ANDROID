package com.br.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;

import java.text.SimpleDateFormat;
import java.util.List;

public class ViewAgendamentos extends AppCompatActivity {
    private Usuario usuario;
    private TextView txtConteudo;
    private TextView txtHora;
    private TextView txtData;
    private TextView txtDescricao;
    private TextView txtContato;

    private RecyclerView recyclerView;
    private AgendamentoAdapter agendamentoAdapter;
    private List<Agendamento> agendamentoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);

        recyclerView = findViewById(R.id.recycler_view_main);


        try {
            Usuario usuario = getIntent().getParcelableExtra("user");

            Agendamento agendamento = new Agendamento(usuario);
            AgendamentoController agendamentoController = new AgendamentoController(ViewAgendamentos.this);

            List<Agendamento> agendamentoList = agendamentoController.listarAgendamentos(agendamento);

            agendamentoAdapter = new AgendamentoAdapter(ViewAgendamentos.this, agendamentoList);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewAgendamentos.this,
                    LinearLayoutManager.VERTICAL, false);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(agendamentoAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}