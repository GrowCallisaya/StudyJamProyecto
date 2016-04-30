package com.example.android.androidkid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

/**
 * Created by Grover on 28/4/16.
 */
public class RopaActivity extends AppCompatActivity {
    ViewPager viewPager ;
    MainSwipeAdapter adapter;
    String puntero_ropa="";

    int imagen_cuerpo=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ropa);
        puntero_ropa = getIntent().getStringExtra("puntero_ropa");
        //Toast.makeText(RopaActivity.this, "recibido: "+ puntero_ropa, Toast.LENGTH_SHORT).show();

        imagen_cuerpo = getIntent().getIntExtra("imagen_andy", 0);
        ImageView imageView = (ImageView) findViewById(R.id.cuadro_cuerpo);
        imageView.setImageResource(imagen_cuerpo);



        viewPager = (ViewPager) findViewById(R.id.view_pager_2);
        adapter = new MainSwipeAdapter(this);
        adapter.SetImagen(R.mipmap.andy_01);
        adapter.SetImagen(R.mipmap.andy_02);
        adapter.SetImagen(R.mipmap.andy_03);
        adapter.SetImagen(R.mipmap.andy_04);
        adapter.SetImagen(R.mipmap.andy_05);
        adapter.SetImagen(R.mipmap.andy_06);
        adapter.SetImagen(R.mipmap.andy_07);


        viewPager.setAdapter(adapter);

    }

    public void AnadirImplementos(View view){
        Intent i = new Intent(RopaActivity.this, ImplementoActivity.class);
        String numero = puntero_ropa+(viewPager.getCurrentItem()+1)+"";

        int imagen_ropa = adapter.GetImagen(viewPager.getCurrentItem());

        i.putExtra("puntero_implemento",numero );
        i.putExtra("imagen_cuerpo_andy",imagen_cuerpo);
        i.putExtra("imagen_ropa_andy",imagen_ropa);
        startActivity(i);

    }
}
