package com.example.cinematicketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewFilm;
    FilmAdapter adapter;
    List<Film> daftarFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilm = findViewById(R.id.recyclerViewFilm);
        recyclerViewFilm.setLayoutManager(new LinearLayoutManager(this));

        daftarFilm = new ArrayList<>();
        daftarFilm.add(new Film("Avengers", "Para superhero menyelamatkan dunia.", R.drawable.avenger));
        daftarFilm.add(new Film("Interstellar", "Perjalanan melintasi waktu dan ruang.", R.drawable.interstellar));
        daftarFilm.add(new Film("Joker", "Kisah kelam tokoh ikonik.", R.drawable.joker));
        daftarFilm.add(new Film("Spiderman", "Pahlawan muda dengan kekuatan laba-laba.", R.drawable.spiderman));
        daftarFilm.add(new Film("Dune", "Perjuangan di planet gurun Arrakis.", R.drawable.dune));

        adapter = new FilmAdapter(this, daftarFilm);
        recyclerViewFilm.setAdapter(adapter);

        findViewById(R.id.btnRiwayat).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, OrderHistoryActivity.class));
        });

    }
}
