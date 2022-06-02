package com.br.agenda.adpter_holder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.agenda.R;
import com.br.agenda.model.bean.Agendamento;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class AgendamentoViewHolder extends RecyclerView.ViewHolder {

    protected TextView txtConteudo;
    protected TextView txtHora;
    protected TextView txtData;
    protected TextView txtDescricao;
    protected Button btnExcluir;
    protected Button btnEditar;


    public AgendamentoViewHolder(@NonNull View itemView) {
        super(itemView);

        txtConteudo = itemView.findViewById(R.id.textConteudo);
        txtHora = itemView.findViewById(R.id.textHora);
        txtData = itemView.findViewById(R.id.textData);
        txtDescricao = itemView.findViewById(R.id.textDescricao);
        btnExcluir = itemView.findViewById(R.id.btExcluir);
        btnEditar = itemView.findViewById(R.id.btEditar);

    }

}
