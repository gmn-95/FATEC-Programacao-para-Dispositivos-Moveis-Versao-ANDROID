package com.br.agenda.adpter_holder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.br.agenda.R;
import com.br.agenda.controller.AgendamentoController;
import com.br.agenda.model.bean.Agendamento;
import com.br.agenda.view.agendamento.ViewAgendamentoEditar;

import java.sql.SQLException;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull AgendamentoViewHolder holder, int position) {

        Agendamento agendamento = agendamentoList.get(position);
        holder.txtDescricao.setText(agendamento.getDescricao());
        holder.txtData.setText(agendamento.getData_agendada());
        holder.txtHora.setText(agendamento.getHora_agendada());
        holder.txtConteudo.setText(agendamento.getConteudo());

        excluir(holder);
        editar(holder);
    }

    private void editar(AgendamentoViewHolder holder){
        holder.btnEditar.setOnClickListener(v -> {
            int newPosition = holder.getAdapterPosition();

            Intent it = new Intent(context, ViewAgendamentoEditar.class);
            it.putExtra("agendamento", (Parcelable) agendamentoList.get(newPosition));
            it.putExtra("data", agendamentoList.get(newPosition).getData_agendada());
            it.putExtra("hora", agendamentoList.get(newPosition).getHora_agendada());

            context.startActivity(it);
            ((AppCompatActivity) context).finish();
        });
    }

    private void excluir(AgendamentoViewHolder holder){
        holder.btnExcluir.setOnClickListener(v -> {
            int newPosition = holder.getAdapterPosition();

            new AlertDialog.Builder(context)
                    .setTitle("Excluindo agendamento")
                    .setMessage("Tem certeza que deseja excluir?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                new AgendamentoController(context).excluir(agendamentoList.get(newPosition));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            agendamentoList.remove(newPosition);
                            notifyItemRemoved(newPosition);
                        }
                    }).setNegativeButton("Não", null).show();
        });
    }

    @Override
    public int getItemCount() {
        return agendamentoList.size();
    }
}
