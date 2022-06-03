package com.br.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.br.agenda.controller.UsuarioController;
import com.br.agenda.model.bean.Usuario;
import com.br.agenda.view.agendamento.ViewAgendamentos;
import com.br.agenda.view.usuario.ViewUsuarioCadastrar;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private Usuario usuario;
    private EditText login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void cadastrar(View view){
        Intent intent = new Intent(MainActivity.this, ViewUsuarioCadastrar.class);
        startActivity(intent);
    }

    public void login(View view){
        try {
            login = (EditText) findViewById(R.id.login);
            senha = (EditText) findViewById(R.id.textInputSenhaCad);

            if(login.getText().toString().isEmpty() && senha.getText().toString().isEmpty()){
                login.setError("Informe o usuário!");
                senha.setError("Informe a senha!");
            }
            else if(login.getText().toString().isEmpty()){
                login.setError("Informe o usuário");
            }
            else if(senha.getText().toString().isEmpty()){
                senha.setError("Informe a senha!");
            }
            else{
                usuario = new Usuario(login.getText().toString(), senha.getText().toString());
                UsuarioController usuarioController = new UsuarioController(MainActivity.this);
                usuario = usuarioController.validaLogin(usuario);

                if(usuario != null){
                    Intent intent = new Intent(MainActivity.this, ViewAgendamentos.class);
                    intent.putExtra("user", (Parcelable) usuario);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
                    login.setText("");
                    senha.setText("");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}