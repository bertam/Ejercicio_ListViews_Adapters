package com.example.bertiwi.ejercicio_listviews_adapters;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_layout);
        Producto producto = getIntent().getParcelableExtra(MainActivity.ITEM_PRODUCTO);
        int cant_selected = getIntent().getIntExtra(MainActivity.CANTIDAD_SEL_SPINNER,0);

        TextView tvNombre = findViewById(R.id.nombre);
        ImageView imImagen = findViewById(R.id.product_imageview);
        TextView tvStock = findViewById(R.id.cantidad_stock);
        Spinner spSpinner = findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i <= producto.getStock(); i++) {
            adapter.add(i);
        }
        spSpinner.setAdapter(adapter);

        tvNombre.setText(producto.getTituloProducto());
        imImagen.setImageResource(producto.getImageId());
        tvStock.setText(String.valueOf(producto.getStock()));
        spSpinner.setSelection(cant_selected, true);



    }
}
