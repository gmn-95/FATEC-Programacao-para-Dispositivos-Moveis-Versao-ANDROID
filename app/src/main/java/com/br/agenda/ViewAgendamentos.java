package com.br.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.model.bean.Usuario;

import java.text.SimpleDateFormat;
import java.util.List;

public class ViewAgendamentos extends AppCompatActivity {
    private Usuario usuario;
    private TextView txtConteudo;
    private TextView txtHora;
    private TextView txtData;
    private TextView txtDescricao;
    private TextView txtContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);

        try {
            Usuario usuario = getIntent().getParcelableExtra("user");

            Agendamento agendamento = new Agendamento(usuario);
            AgendamentoController agendamentoController = new AgendamentoController(ViewAgendamentos.this);

            List<Agendamento> agendamentoList = agendamentoController.listarAgendamentos(agendamento);

            txtConteudo = (TextView) findViewById(R.id.textDescricao);
            txtData = (TextView) findViewById(R.id.textData);
            txtHora = (TextView) findViewById(R.id.textHora);
            txtDescricao = (TextView) findViewById(R.id.textConteudo);
            txtContato = (TextView) findViewById(R.id.textContato);

            SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
            SimpleDateFormat data = new SimpleDateFormat("dd-mm-yyyy");
            System.out.println(agendamentoList.get(0));
            if(agendamentoList != null){
                for (Agendamento age : agendamentoList){
                    txtConteudo.setText(age.getConteudo());
                    txtHora.setText(hora.format(age.getHora_agendada()));
                    txtData.setText(data.format(age.getData_agendada()));
                    txtDescricao.setText(age.getDescricao());
                    txtContato.setText(age.getContato().getNome());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}