package com.example.cinematicketbookingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView txtJudulFilm, txtDeskripsiFilm;
    EditText etNama, etEmail, etJumlahTiket;
    Button btnPesan;
    ImageView imgFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ambil data dari Intent
        String judul = getIntent().getStringExtra("judul");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        int gambar = getIntent().getIntExtra("gambar", 0);

        Log.d("GAMBAR", "Gambar yang dikirim: " + gambar);

        // Bind views
        txtJudulFilm = findViewById(R.id.txtJudulFilm);
        txtDeskripsiFilm = findViewById(R.id.txtDeskripsiFilm);
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etJumlahTiket = findViewById(R.id.etJumlahTiket);
        btnPesan = findViewById(R.id.btnPesan);
        imgFilm = findViewById(R.id.imgFilm);

        // Set isi tampilan
        txtJudulFilm.setText(judul);
        txtDeskripsiFilm.setText(deskripsi);
        imgFilm.setImageResource(gambar);

        // Tombol pesan
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String jumlah = etJumlahTiket.getText().toString();

                if (nama.isEmpty() || email.isEmpty() || jumlah.isEmpty()) {
                    Toast.makeText(DetailActivity.this, "Isi semua data!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "Tiket " + judul + " berhasil dipesan!", Toast.LENGTH_LONG).show();
                }
                SharedPreferences prefs = getSharedPreferences("RIWAYAT", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                String oldData = prefs.getString("data", "");

                String newData = nama + ";" + email + ";" + judul + ";" + jumlah + "\n";
                editor.putString("data", oldData + newData);
                editor.apply();

            }
        });
    }
}
