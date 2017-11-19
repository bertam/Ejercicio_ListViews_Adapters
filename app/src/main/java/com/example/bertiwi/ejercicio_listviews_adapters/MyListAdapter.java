package com.example.bertiwi.ejercicio_listviews_adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Bertiwi on 15/11/2017.
 */

public class MyListAdapter extends BaseAdapter{

    private Context context;
    private List<Producto> listaProductos;
    private LayoutInflater inflater;
    private int item_layout;

    public MyListAdapter(Context context, List<Producto> listaProductos, int item_layout) {
        this.context = context;
        this.listaProductos = listaProductos;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null){
            view = inflater.inflate(item_layout,null);
        }

        TextView tvNombre = (TextView) view.findViewById(R.id.nombre);
        ImageView tvImagen = (ImageView) view.findViewById(R.id.product_imageview);
        TextView tvStock = (TextView) view.findViewById(R.id.cantidad_stock);
        Spinner spSpinner = (Spinner) view.findViewById(R.id.spinner);

        tvNombre.setText(listaProductos.get(position).getTituloProducto());
        tvImagen.setImageResource(listaProductos.get(position).getImageId());
        tvStock.setText(String.valueOf(listaProductos.get(position).getStock()));

        ArrayAdapter adapter = new ArrayAdapter(context.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i <= listaProductos.get(position).getStock(); i++) {
            adapter.add(i);
        }
        spSpinner.setAdapter(adapter);

        return view;
    }
}
