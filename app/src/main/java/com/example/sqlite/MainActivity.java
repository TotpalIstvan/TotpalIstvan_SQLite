package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnListazasra, btnRogzitesre, btnModositasra, btnTorlesre;
    private TextView textLista;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        textLista.setMovementMethod(new ScrollingMovementMethod());
        btnRogzitesre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rogzitesre = new Intent(MainActivity.this, RogzitesActivity.class);
                startActivity(rogzitesre);
                finish();
            }
        });

        btnListazasra.setOnClickListener(v ->{
            Cursor adatok = adatbazis.listaz();
        if(adatok.getCount() == 0){
            Toast.makeText(this, "Nincs az adatbázisban bejegyzes", Toast.LENGTH_SHORT).show();
        }else {
            StringBuilder bobTheBuilder = new StringBuilder();
            while (adatok.moveToNext()){
                bobTheBuilder.append("ID: " + adatok.getInt(0));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Vezetkéknév: " + adatok.getString(1));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Keresztnév: " + adatok.getString(2));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append("Jegy: "
                        + adatok.getInt(3));
                bobTheBuilder.append(System.lineSeparator());
                bobTheBuilder.append(System.lineSeparator());
            }
            textLista.setText(bobTheBuilder.toString());
        }
    });
    }
    private void init() {
        btnListazasra = findViewById(R.id.btn_olvasas);
        btnRogzitesre = findViewById(R.id.btn_rogzites);
        btnModositasra = findViewById(R.id.btn_modositas);
        btnTorlesre = findViewById(R.id.btn_torles);
        textLista = findViewById(R.id.text_lista);
        adatbazis = new DBHelper(this);
    }
}