package com.dportenis.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webActivity extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView)findViewById(R.id.wView);

        String URL = getIntent().getStringExtra("webSite");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://" + URL);
    }

    //Cierra el Activity
    public void Cerrar (View view){
        finish();
    }
}