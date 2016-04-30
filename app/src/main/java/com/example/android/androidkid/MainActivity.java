package com.example.android.androidkid;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager ;
    MainSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new MainSwipeAdapter(this);


        adapter.SetImagen(R.mipmap.andy_1);
        adapter.SetImagen(R.mipmap.andy_2);

        viewPager.setAdapter(adapter);
    }


    public void CambiarRopa(View view){
        Intent i = new Intent(MainActivity.this, RopaActivity.class);
        String numero = (viewPager.getCurrentItem()+1)+"";

        int imagen = adapter.GetImagen(viewPager.getCurrentItem());

        i.putExtra("puntero_ropa",numero );
        i.putExtra("imagen_andy",imagen);
        startActivity(i);


    }
}
