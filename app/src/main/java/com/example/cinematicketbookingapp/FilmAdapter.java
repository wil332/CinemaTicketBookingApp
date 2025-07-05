package com.example.cinematicketbookingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private Context context;
    private List<Film> filmList;

    public FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
        Film film = filmList.get(position);
        holder.txtJudul.setText(film.getJudul());
        holder.txtDeskripsi.setText(film.getDeskripsi());
        holder.imgFilm.setImageResource(film.getGambar());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("judul", film.getJudul());
            intent.putExtra("deskripsi", film.getDeskripsi());
            intent.putExtra("gambar", film.getGambar());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtJudul, txtDeskripsi;
        ImageView imgFilm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudul = itemView.findViewById(R.id.txtJudul);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);
            imgFilm = itemView.findViewById(R.id.imgFilm);
        }
    }
}
