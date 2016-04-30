package com.example.android.androidkid;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Grover on 28/4/16.
 */
public class FinalActivity extends AppCompatActivity{
    ViewPager viewPager ;
    MainSwipeAdapter adapter;
    String puntero_final="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        puntero_final = getIntent().getStringExtra("puntero_final");
        //Toast.makeText(FinalActivity.this, "recibido: " + puntero_final, Toast.LENGTH_SHORT).show();

        int [] imagenes_finales = {R.mipmap.andy_111,R.mipmap.andy_112,R.mipmap.andy_121,R.mipmap.andy_122,R.mipmap.andy_131,R.mipmap.andy_132,R.mipmap.andy_141,R.mipmap.andy_142,R.mipmap.andy_151,R.mipmap.andy_152,R.mipmap.andy_161,R.mipmap.andy_162,R.mipmap.andy_171,R.mipmap.andy_172,R.mipmap.andy_211,R.mipmap.andy_212,R.mipmap.andy_221,R.mipmap.andy_222,R.mipmap.andy_231,R.mipmap.andy_232,R.mipmap.andy_241,R.mipmap.andy_242,R.mipmap.andy_251,R.mipmap.andy_252,R.mipmap.andy_261,R.mipmap.andy_262,R.mipmap.andy_271,R.mipmap.andy_272};

        viewPager = (ViewPager) findViewById(R.id.view_pager_2);
        adapter = new MainSwipeAdapter(this);

        //buscamos la imagen final
        int indice_final = 0;
        if('2' == (puntero_final.charAt(0))) {
            indice_final = 14;
        }
        int operacion =((int)puntero_final.charAt(1))-48;
        indice_final+= ((operacion*2)-1);
        //lo colocamos en nuestro imageView
        if (puntero_final.charAt(2)=='1')
            adapter.SetImagen(imagenes_finales[indice_final-1]);
        else
            adapter.SetImagen(imagenes_finales[indice_final]);

        viewPager.setAdapter(adapter);
    }

}
