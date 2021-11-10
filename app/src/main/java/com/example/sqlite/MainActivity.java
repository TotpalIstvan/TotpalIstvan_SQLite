package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnListazasra, btnRogzitesre, btnModositasra, btnTorlesre;
    private TextView textLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnRogzitesre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rogzitesre = new Intent(MainActivity.this, RogzitesActivity.class);
                startActivity(rogzitesre);
                finish();
            }
        });
    }
    private void init() {
        btnListazasra = findViewById(R.id.btn_olvasas);
        btnRogzitesre = findViewById(R.id.btn_rogzites);
        btnModositasra = findViewById(R.id.btn_modositas);
        btnTorlesre = findViewById(R.id.btn_torles);
        textLista = findViewById(R.id.text_lista);
    }
}