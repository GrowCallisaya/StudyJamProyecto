package com.example.android.androidkid;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.Vector;

/**
 * Created by Grover on 28/4/16.
 */
public class MainSwipeAdapter extends PagerAdapter {
    //imagenes
    private Vector<Integer> imagenes = new Vector<>();

    //Contexto
    private Context ctx;
    //Inflador
    private LayoutInflater layoutInflater;

    public MainSwipeAdapter(Context ctx){
        this.ctx=ctx;
    }

    //metodos de Grow
    public void SetImagen(int imagen){
        imagenes.add(imagen);
    }
    public int GetImagen(int posicion){return imagenes.get(posicion);}



    //metodos del Page Adapter
    @Override
    public int getCount() {
        return imagenes.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == (LinearLayout)object);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);

        //apuntamos con los punteros
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);

        //setteamos imagen y texto
        imageView.setImageResource(imagenes.get(position));

        //lo colocamos en el contenedor
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);


    }

}
