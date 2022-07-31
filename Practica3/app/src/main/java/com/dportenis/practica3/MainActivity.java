package com.dportenis.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText) findViewById(R.id.txtBuscar);
    }

    //Metodo para Buscar web
    public void  Buscar(View view){
        Intent i = new Intent(this, webActivity.class);
        i.putExtra( "webSite", txt1.getText().toString());
        startActivity(i);
    }

}