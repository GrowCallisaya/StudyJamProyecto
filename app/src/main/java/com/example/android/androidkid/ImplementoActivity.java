package com.example.android.androidkid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Grover on 28/4/16.
 */
public class ImplementoActivity extends AppCompatActivity{
    ViewPager viewPager ;
    MainSwipeAdapter adapter;
    String puntero_implemento="";

    int imagen_cuerpo=0;
    int imagen_ropa=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implemento);
        puntero_implemento = getIntent().getStringExtra("puntero_implemento");
        //Toast.makeText(ImplementoActivity.this, "recibido: " + puntero_implemento, Toast.LENGTH_SHORT).show();

        imagen_cuerpo = getIntent().getIntExtra("imagen_cuerpo_andy", 0);
        ImageView imageViewCuerpo = (ImageView) findViewById(R.id.cuadro_cuerpo);
        imageViewCuerpo.setImageResource(imagen_cuerpo);

        imagen_ropa = getIntent().getIntExtra("imagen_ropa_andy", 0);
        ImageView imageViewRopa = (ImageView) findViewById(R.id.cuadro_ropa);
        imageViewRopa.setImageResource(imagen_ropa);

        viewPager = (ViewPager) findViewById(R.id.view_pager_2);
        adapter = new MainSwipeAdapter(this);
        adapter.SetImagen(R.mipmap.andy_002);
        adapter.SetImagen(R.mipmap.andy_001);

        viewPager.setAdapter(adapter);
    }

    public void Finalizar(View vista){
        Intent i = new Intent(ImplementoActivity.this, FinalActivity.class);
        String numero = puntero_implemento+(viewPager.getCurrentItem()+1)+"";

        i.putExtra("puntero_final",numero );
        startActivity(i);

    }
}
