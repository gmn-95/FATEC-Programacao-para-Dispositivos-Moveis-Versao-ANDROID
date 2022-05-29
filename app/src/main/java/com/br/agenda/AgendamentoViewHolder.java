package com.br.agenda;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AgendamentoViewHolder extends RecyclerView.ViewHolder {

    public TextView txtConteudo;
    public TextView txtHora;
    public TextView txtData;
    public TextView txtDescricao;
    public TextView txtContato;

    public AgendamentoViewHolder(@NonNull View itemView) {
        super(itemView);

        txtConteudo = itemView.findViewById(R.id.textConteudo);
        txtHora = itemView.findViewById(R.id.textHora);
        txtData = itemView.findViewById(R.id.textData);
        txtDescricao = itemView.findViewById(R.id.textDescricao);
        txtContato = itemView.findViewById(R.id.textContato);
    }
}
