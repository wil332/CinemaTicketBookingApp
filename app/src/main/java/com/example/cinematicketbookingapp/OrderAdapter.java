package com.example.cinematicketbookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context context;
    private List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtEmail, txtJudul, txtJumlah;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtJudul = itemView.findViewById(R.id.txtJudul);
            txtJumlah = itemView.findViewById(R.id.txtJumlah);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.txtNama.setText("Nama: " + order.getNama());
        holder.txtEmail.setText("Email: " + order.getEmail());
        holder.txtJudul.setText("Film: " + order.getJudulFilm());
        holder.txtJumlah.setText("Jumlah: " + order.getJumlah());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
