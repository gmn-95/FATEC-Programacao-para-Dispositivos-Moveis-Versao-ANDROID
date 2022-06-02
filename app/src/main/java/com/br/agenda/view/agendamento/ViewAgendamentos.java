package com.br.agenda.view.agendamento;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.br.agenda.MainActivity;
import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.SQLException;
import java.util.List;

public class ViewAgendamentos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AgendamentoAdapter agendamentoAdapter;
    private List<Agendamento> agendamentoList;
    private Agendamento agendamento;
    private AgendamentoController agendamentoController;
    private Usuario usuario;

    public ViewAgendamentos() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);

        usuario = getIntent().getParcelableExtra("user");

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewAgendamentos.this, MainActivity.class);
                setResult(0, intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        carregarAgendamentos();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarAgendamentos();
    }

    public void criar(View view){
        Intent intent = new Intent(ViewAgendamentos.this, ViewAgendamentoCriar.class);
        intent.putExtra("user", (Parcelable) usuario);
        startActivity(intent);
    }

    private void carregarAgendamentos(){
        recyclerView = findViewById(R.id.recycler_view_main);

        try {
            usuario = getIntent().getParcelableExtra("user");

            agendamento = new Agendamento(usuario);
            agendamentoController = new AgendamentoController(ViewAgendamentos.this);

            agendamentoList = agendamentoController.listarAgendamentos(agendamento);

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