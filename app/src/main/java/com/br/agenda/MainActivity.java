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

import java.sql.SQLException;

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}