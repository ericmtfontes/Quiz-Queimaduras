package com.example.projetolpiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button btnIniciarJogo = (Button) findViewById(R.id.btnIniciarJogo);
        Button btnComoJogar =  (Button) findViewById(R.id.btnComoJogar);
        Button btnSobre =  (Button) findViewById(R.id.btnSobre);
        Button btnReferencias = (Button) findViewById(R.id.btnReferencias);
        Button btnSair = (Button) findViewById(R.id.btnSair);

        btnIniciarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, telaPerguntas.class);
                startActivity(intent);
            }
        });

        btnComoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, telaComoJogar.class);
                startActivity(intent);
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, telaSobre.class);
                startActivity(intent);
            }
        });

        btnReferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, telaReferencias.class);
                startActivity(intent);
            }
        });

        //Bot??o para fechar a aplica????o
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}