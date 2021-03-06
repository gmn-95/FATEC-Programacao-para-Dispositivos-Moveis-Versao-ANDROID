package com.br.agenda.view.agendamento;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.util.MaskEditUtil;

import java.sql.SQLException;
import java.text.ParseException;

public class ViewAgendamentoEditar extends AppCompatActivity {

    private EditText txtData;
    private EditText txtHora;
    private EditText txtConteudo;
    private EditText txtDescricao;
    private Agendamento agendamento;
    private AgendamentoController agendamentoController;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agendamento_editar);

        agendamento = getIntent().getParcelableExtra("agendamento");
        String data = getIntent().getStringExtra("data");
        String hora = getIntent().getStringExtra("hora");
        agendamento.setData_agendada(data);
        agendamento.setHora_agendada(hora);

        txtData = findViewById(R.id.inputEditDate);
        txtHora = findViewById(R.id.inputEditHora);
        txtConteudo = findViewById(R.id.textInputUsuarioCad);
        txtDescricao = findViewById(R.id.textInputNomeCad);

        txtData.addTextChangedListener(MaskEditUtil.mask(txtData, MaskEditUtil.FORMAT_DATE));
        txtHora.addTextChangedListener(MaskEditUtil.mask(txtHora, MaskEditUtil.FORMAT_HOUR));

        txtConteudo.setText(agendamento.getConteudo());
        txtDescricao.setText(agendamento.getDescricao());
        txtData.setText(agendamento.getData_agendada());
        txtHora.setText(agendamento.getHora_agendada());


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewAgendamentoEditar.this, ViewAgendamentos.class);
                intent.putExtra("user", (Parcelable) agendamento.getUsuario());
                startActivity(intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void editarAgendamento(View view) throws ParseException, SQLException {

        txtData = findViewById(R.id.inputEditDate);
        txtHora = findViewById(R.id.inputEditHora);
        txtConteudo = findViewById(R.id.textInputUsuarioCad);
        txtDescricao = findViewById(R.id.textInputNomeCad);

        if(txtData.getText().toString().isEmpty() && txtHora.getText().toString().isEmpty()
                && txtDescricao.getText().toString().isEmpty()
                && txtConteudo.getText().toString().isEmpty()){

            txtData.setError("Informe a Data!");
            txtHora.setError("Informe a Hora!");
            txtConteudo.setError("Informe o Conte??do!");
            txtDescricao.setError("Informe a Descri????o!");
        }
        else if(txtData.getText().toString().isEmpty()){
            txtData.setError("Informe a Data!");
        }
        else if(txtHora.getText().toString().isEmpty()){
            txtHora.setError("Informe a Hora!");
        }
        else if(txtDescricao.getText().toString().isEmpty()){
            txtConteudo.setError("Informe o Conte??do!");
        }
        else if(txtConteudo.getText().toString().isEmpty()){
            txtDescricao.setError("Informe a Descri????o!");
        }
        else{

            agendamento.setConteudo(txtConteudo.getText().toString());
            agendamento.setDescricao(txtDescricao.getText().toString());
            agendamento.setData_agendada(txtData.getText().toString());
            agendamento.setHora_agendada(txtHora.getText().toString());

            agendamentoController = new AgendamentoController(ViewAgendamentoEditar.this);
            agendamentoController.atualizar(agendamento);

            Intent intent = new Intent(ViewAgendamentoEditar.this, ViewAgendamentos.class);
            intent.putExtra("user", (Parcelable) agendamento.getUsuario());
            startActivity(intent);
            finish();
        }
    }
}