package com.br.agenda.view.agendamento;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.agenda.R;
import com.br.agenda.model.bean.Agendamento;

import java.util.List;


public class AgendamentoViewHolder extends RecyclerView.ViewHolder {

    public TextView txtConteudo;
    public TextView txtHora;
    public TextView txtData;
    public TextView txtDescricao;
    public Button btnExcluir;

    public AgendamentoViewHolder(@NonNull View itemView) {
        super(itemView);

        txtConteudo = itemView.findViewById(R.id.textConteudo);
        txtHora = itemView.findViewById(R.id.textHora);
        txtData = itemView.findViewById(R.id.textData);
        txtDescricao = itemView.findViewById(R.id.textDescricao);
        btnExcluir = itemView.findViewById(R.id.btExcluir);

    }

}
