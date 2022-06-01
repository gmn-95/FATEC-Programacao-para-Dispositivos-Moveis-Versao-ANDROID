package com.br.agenda.view.agendamento;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.br.agenda.MainActivity;
import com.br.agenda.R;
import com.br.agenda.model.bean.Usuario;

public class ViewAgendamentoCriar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agendamento_criar);

        Usuario usuario = getIntent().getParcelableExtra("user");

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewAgendamentoCriar.this, ViewAgendamentos.class);
                setResult(0, intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        //metodo para salvar - coloque resultCOde = 1

    }
}