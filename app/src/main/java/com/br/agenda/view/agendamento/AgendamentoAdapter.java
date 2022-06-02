package com.br.agenda.view.agendamento;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.util.DBHelper;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AgendamentoAdapter extends RecyclerView.Adapter<AgendamentoViewHolder> {

    private Context context;
    private List<Agendamento> agendamentoList;

    public AgendamentoAdapter(List<Agendamento> agendamentoList) {
        this.agendamentoList = agendamentoList;
    }

    public AgendamentoAdapter(Context context, List<Agendamento> agendamentoList) {
        this.context = context;
        this.agendamentoList = agendamentoList;
    }

    @NonNull
    @Override
    public AgendamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itens_agendamento, parent, false);
        AgendamentoViewHolder agendamentoViewHolder = new AgendamentoViewHolder(view);

        return agendamentoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AgendamentoViewHolder holder, int position) {
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat data = new SimpleDateFormat("dd-mm-yyyy");

        Agendamento agendamento = agendamentoList.get(position);
        holder.txtDescricao.setText(agendamento.getDescricao());
        holder.txtData.setText(data.format(agendamento.getData_agendada()));
        holder.txtHora.setText(hora.format(agendamento.getHora_agendada()));
        holder.txtConteudo.setText(agendamento.getConteudo());

        holder.btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newPosition = holder.getAdapterPosition();
                try {
                    new AgendamentoController(context).excluir(agendamentoList.get(newPosition));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                agendamentoList.remove(newPosition);
                notifyItemRemoved(newPosition);
            }
        });

    }

    @Override
    public int getItemCount() {
        return agendamentoList.size();
    }
}
