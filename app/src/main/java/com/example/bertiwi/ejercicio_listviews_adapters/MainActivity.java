package com.example.bertiwi.ejercicio_listviews_adapters;

import android.content.ClipData;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public static final String ITEM_PRODUCTO = "AQUI ESTA EL PRODUCTO";
    public static final String CANTIDAD_SEL_SPINNER = "ESTO ES EL SPINNER";
    private Spinner spQuantity;
    public static int estock = 20;
    private List<Producto> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDataModel();

        ListView lView = findViewById(R.id.listView);
        MyListAdapter adapterLista = new MyListAdapter(this, data, R.layout.product_layout);
        lView.setAdapter(adapterLista);

        lView.setOnItemClickListener(this);
        /*listview.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position){
                ItemClicked item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });*/

        //lView.setOnClickListener((View.OnClickListener) this);
    }

    private void createDataModel(){
        data = new ArrayList<Producto>();
        String[] noms = this.getResources().getStringArray(R.array.nombre_productos);
        int[] estoc = this.getResources().getIntArray(R.array.stock_array);
        Producto item;
        for (int i = 0; i < noms.length; i++) {
            item = new Producto(noms[i], this.getResources().getIdentifier("ic_android", "drawable", this.getPackageName()), estoc[i] );
            data.add(item);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producto producto = (Producto) parent.getItemAtPosition(position);
        Intent intent = new Intent(this,SecondActivity.class);
        Spinner spSpinner = (Spinner) view.findViewById(R.id.spinner);
        intent.putExtra(ITEM_PRODUCTO, producto);
        intent.putExtra(CANTIDAD_SEL_SPINNER, Integer.valueOf(String.valueOf(spSpinner.getSelectedItem())));
        Toast.makeText(this,String.valueOf(spSpinner.getSelectedItem()),Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, data.get(position).getName(), Toast.LENGTH_LONG).show();
    } */
}


