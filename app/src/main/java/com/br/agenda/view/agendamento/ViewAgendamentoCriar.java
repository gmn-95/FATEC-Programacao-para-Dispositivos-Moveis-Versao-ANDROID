package com.br.agenda.view.agendamento;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.br.agenda.MainActivity;
import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ViewAgendamentoCriar extends AppCompatActivity {

    private EditText txtData;
    private EditText txtHora;
    private EditText txtConteudo;
    private EditText txtDescricao;
    private Usuario usuario;
    private Agendamento agendamento;
    private AgendamentoController agendamentoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agendamento_criar);

        usuario = getIntent().getParcelableExtra("user");

        txtData = findViewById(R.id.inputDate);
        txtHora = findViewById(R.id.inputHora);

        txtData.addTextChangedListener(MaskEditUtil.mask(txtData, MaskEditUtil.FORMAT_DATE));
        txtHora.addTextChangedListener(MaskEditUtil.mask(txtHora, MaskEditUtil.FORMAT_HOUR));

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewAgendamentoCriar.this, ViewAgendamentos.class);
                intent.putExtra("user", (Parcelable) usuario);
                startActivity(intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode + resultCode);
    }

    public void criarAgendamento(View view) throws ParseException, SQLException {

        txtData = findViewById(R.id.inputDate);
        txtHora = findViewById(R.id.inputHora);
        txtConteudo = findViewById(R.id.inputConteudo);
        txtDescricao = findViewById(R.id.inputDescricao);

        if(txtData.getText().toString().isEmpty() && txtHora.getText().toString().isEmpty()
                && txtDescricao.getText().toString().isEmpty() && txtConteudo.getText().toString().isEmpty()){

            txtData.setError("Informe a Data!");
            txtHora.setError("Informe a Hora!");
            txtConteudo.setError("Informe o Conteúdo!");
            txtDescricao.setError("Informe a Descrição!");
        }
        else if(txtData.getText().toString().isEmpty()){
            txtData.setError("Informe a Data!");
        }
        else if(txtHora.getText().toString().isEmpty()){
            txtHora.setError("Informe a Hora!");
        }
        else if(txtDescricao.getText().toString().isEmpty()){
            txtConteudo.setError("Informe o Conteúdo!");
        }
        else if(txtConteudo.getText().toString().isEmpty()){
            txtDescricao.setError("Informe a Descrição!");
        }
        else{
            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            SimpleDateFormat data = new SimpleDateFormat("dd-mm-yyyy");

            usuario = getIntent().getParcelableExtra("user");

            agendamento = new Agendamento(usuario, data.parse(txtData.getText().toString()),
                    hora.parse(txtHora.getText().toString()), txtDescricao.getText().toString(),
                    txtConteudo.getText().toString());

            agendamentoController = new AgendamentoController(ViewAgendamentoCriar.this);
            agendamentoController.inserir(agendamento);

            Intent intent = new Intent(ViewAgendamentoCriar.this, ViewAgendamentos.class);
            intent.putExtra("user", (Parcelable) usuario);
            startActivity(intent);
            finish();
        }
    }
}