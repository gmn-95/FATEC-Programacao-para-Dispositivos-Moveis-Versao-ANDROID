package com.br.agenda.view.usuario;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.br.agenda.MainActivity;
import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.controller.UsuarioController;
import com.br.agenda.model.bean.Usuario;
import com.br.agenda.view.agendamento.ViewAgendamentoCriar;
import com.br.agenda.view.agendamento.ViewAgendamentos;

import java.sql.SQLException;

public class ViewUsuarioCadastrar extends AppCompatActivity {

    private EditText login, senha, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_usuario_cadastrar);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewUsuarioCadastrar.this, MainActivity.class);
                setResult(0, intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        nome = (EditText) findViewById(R.id.textInputNomeCad);
        login = (EditText) findViewById(R.id.textInputUsuarioCad);
        senha = (EditText) findViewById(R.id.textInputSenhaCad);
    }

    public void cadastrarUsuario(View view){
        try {

            if(nome.getText().toString().isEmpty() && login.getText().toString().isEmpty()
                    && senha.getText().toString().isEmpty()){

                nome.setError("Informe o Nome!");
                login.setError("Informe o Usuário!");
                senha.setError("Informe a Senha!");
            }
            else if(nome.getText().toString().isEmpty()){
                nome.setError("Informe o Nome!");
            }
            else if(login.getText().toString().isEmpty()){
                login.setError("Informe o Usuário!");
            }
            else if(senha.getText().toString().isEmpty()){
                senha.setError("Informe a Senha!");
            }
            else{
                Usuario usuario = new Usuario(nome.getText().toString(), login.getText().toString(), senha.getText().toString());
                UsuarioController usuarioController = new UsuarioController(ViewUsuarioCadastrar.this);
                usuarioController.inserir(usuario);

                Intent intent = new Intent(ViewUsuarioCadastrar.this, MainActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_LONG)
                        .show();
            }
        }
        catch (SQLException e){
            new AlertDialog.Builder(ViewUsuarioCadastrar.this)
                    .setTitle("Usuário existente!")
                    .setMessage("Usuário já existe!")
                    .setNeutralButton("OK", null).show();

            login.setText("");
        }
    }
}