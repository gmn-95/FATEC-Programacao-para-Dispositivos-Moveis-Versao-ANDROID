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
import com.br.agenda.util.PovoaBanco;
import com.br.agenda.view.agendamento.ViewAgendamentos;

import java.sql.SQLException;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private Usuario usuario;
    private EditText login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickBotao(View view){
        try {
            login = (EditText) findViewById(R.id.login);
            senha = (EditText) findViewById(R.id.senha);

            if(login.getText().toString().isEmpty() && senha.getText().toString().isEmpty()){
                login.setError("Informe o login!");
                senha.setError("Informe a senha!");
            }
            else if(login.getText().toString().isEmpty()){
                login.setError("Informe o login");
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
                    finish();
                }
                else{
                    Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                    login.setText("");
                    senha.setText("");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}