package com.example.cinematicketbookingapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewOrder;
    OrderAdapter adapter;
    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        recyclerViewOrder = findViewById(R.id.recyclerViewOrder);
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(this));

        orders = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("RIWAYAT", MODE_PRIVATE);
        String data = prefs.getString("data", "");

        for (String row : data.split("\n")) {
            String[] bagian = row.split(";");
            if (bagian.length == 4) {
                orders.add(new Order(bagian[0], bagian[1], bagian[2], Integer.parseInt(bagian[3])));
            }
        }

        adapter = new OrderAdapter(this, orders);
        recyclerViewOrder.setAdapter(adapter);
    }
}
