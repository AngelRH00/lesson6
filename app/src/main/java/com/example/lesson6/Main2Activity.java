package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    private Date date;
    private Button Fecha;
    private CheckBox caja;
    private String[] mensajes = {"EH DESMÁRCAME","Mejor. Gracias.", "Basta por favor :(", "Pues vale, haz lo que quieras, me da igual."};
    private int contador = 0;
    private RadioButton rojo;
    private RadioButton amarillo;
    private RadioButton azul;
    private TextView colores;
    private TextView textoFijo;
    private TextView textoEditable;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void botonFecha(View view){
        date = new Date();
        Fecha = findViewById(R.id.fecha);
        Fecha.setBackgroundColor(Color.RED);
        Fecha.setText(date.toString());
    }
    public void caja(View view) {
        caja = findViewById(R.id.caja);
        if(caja.isChecked()){
            caja.setText(mensajes[contador] + " ✓");
        }else{
            caja.setText(mensajes[contador] + " X");
        }
        if(contador<3) contador++;
    }

    public void colorear(View view){
        rojo = findViewById(R.id.rojo);
        amarillo = findViewById(R.id.amarillo);
        azul = findViewById(R.id.azul);
        colores = findViewById(R.id.textoColorear);

        if(rojo.isChecked()){
            colores.setBackgroundColor(Color.RED);
        }else if(amarillo.isChecked()){
            colores.setBackgroundColor(Color.YELLOW);
        }else if (azul.isChecked()){
            colores.setBackgroundColor(Color.BLUE);
        }
    }

    public void botonImagen(View view){
        mp = MediaPlayer.create(this, R.raw.jason);
        textoFijo = findViewById(R.id.textoFijo);
        textoEditable = findViewById(R.id.textoEditable);
        textoEditable.setText(textoFijo.getText());
        mp.start();
    }
}
