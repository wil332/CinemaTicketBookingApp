package com.example.cinematicketbookingapp;

public class Order {
    private String nama, email, judulFilm;
    private int jumlah;

    public Order(String nama, String email, String judulFilm, int jumlah) {
        this.nama = nama;
        this.email = email;
        this.judulFilm = judulFilm;
        this.jumlah = jumlah;
    }

    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getJudulFilm() { return judulFilm; }
    public int getJumlah() { return jumlah; }
}
