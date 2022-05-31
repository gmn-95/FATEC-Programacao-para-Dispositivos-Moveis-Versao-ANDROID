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


            //INSERSÃO TEMPORÁRIA
            /*

            AgendamentoController agendamentoController = new AgendamentoController(MainActivity.this);

            ContatoController contatoController = new ContatoController(MainActivity.this);
            Contato contato = contatoController.buscar(1);

            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            SimpleDateFormat data = new SimpleDateFormat("dd-mm-yyyy");

            Agendamento agendamento = new Agendamento(11, contato, usuario, data.parse("10-06-2022"), hora.parse("19:00"),
                    "Aniversário", "Meu aniversário");

            agendamentoController.atualizar(agendamento);

            this.id = id;
            this.contato = contato;
            this.usuario = usuario;
            this.data_agendada = data_agendada;
            this.hora_agendada = hora_agendada;
            this.descricao = descricao;
            this.conteudo = conteudo;

            ContatoController contatoController = new ContatoController(MainActivity.this);
            contatoController.inserir(new Contato(usuario, "Professor", "(11) 5896-7855",
                    "(11) 94586-8784", "professor@gmail", ""));

            Contato contato = contatoController.buscar(2);

            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            SimpleDateFormat data = new SimpleDateFormat("dd-mm-yyyy");

            AgendamentoController agendamentoController = new AgendamentoController(MainActivity.this);
            agendamentoController.inserir(new Agendamento(contato, usuario, data.parse("31-05-2022"),
                    hora.parse("18:00"), "Entrega Atividade", "Entrega o projeto mobile"));
*/
            //FIM

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