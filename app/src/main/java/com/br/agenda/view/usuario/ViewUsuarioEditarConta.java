package com.br.agenda.view.usuario;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.br.agenda.view.agendamento.ViewAgendamentos;

import java.sql.SQLException;

public class ViewUsuarioEditarConta extends AppCompatActivity {

    private Usuario usuario;
    private UsuarioController usuarioController;

    private EditText login, senha, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_usuario_editar_conta);

        usuario = getIntent().getParcelableExtra("user");

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ViewUsuarioEditarConta.this, ViewAgendamentos.class);
                intent.putExtra("user", (Parcelable) usuario);
                startActivity(intent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        nome = (EditText) findViewById(R.id.textInputNomeEditar);
        login = (EditText) findViewById(R.id.textInputUsuarioEditar);
        senha = (EditText) findViewById(R.id.textInputSenhaEditar);

        nome.setText(usuario.getNome());
        login.setText(usuario.getLogin());
        senha.setText(usuario.getSenha());

    }

    public void editarConta(View view){

        try {

            if(login.getText().toString().isEmpty() && senha.getText().toString().isEmpty()){
                login.setError("Informe o usu??rio!");
                senha.setError("Informe a senha!");
            }
            else if(login.getText().toString().isEmpty()){
                login.setError("Informe o usu??rio");
            }
            else if(senha.getText().toString().isEmpty()){
                senha.setError("Informe a senha!");
            }
            else{
                Usuario usu = new Usuario(usuario.getId(), nome.getText().toString(), login.getText().toString(), senha.getText().toString());
                usuarioController = new UsuarioController(ViewUsuarioEditarConta.this);
                usuarioController.atualiza(usu);

                Toast.makeText(this, "Usu??rio editado com sucesso!", Toast.LENGTH_LONG)
                        .show();

                Intent intent = new Intent(ViewUsuarioEditarConta.this, ViewAgendamentos.class);
                intent.putExtra("user", (Parcelable) usu);
                startActivity(intent);
                finish();
            }

        }
        catch (SQLException e){
            new AlertDialog.Builder(ViewUsuarioEditarConta.this)
                    .setTitle("Usu??rio existente!")
                    .setMessage("Usu??rio j?? existe!")
                    .setNeutralButton("OK", null).show();

            login.setText("");
        }
    }

    public void excluirConta(View view){

        new AlertDialog.Builder(ViewUsuarioEditarConta.this)
                .setTitle("Excluindo conta")
                .setMessage("Tem certeza que deseja excluir?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            AgendamentoController agendamentoController = new AgendamentoController(ViewUsuarioEditarConta.this);
                            usuarioController = new UsuarioController(ViewUsuarioEditarConta.this);

                            agendamentoController.excluirPorUsuario(usuario);
                            usuarioController.excluir(usuario);

                            Toast.makeText(ViewUsuarioEditarConta.this, "Conta exclu??da com sucesso!", Toast.LENGTH_LONG)
                                    .show();

                            Intent intent = new Intent(ViewUsuarioEditarConta.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }).setNegativeButton("N??o", null).show();
    }
}