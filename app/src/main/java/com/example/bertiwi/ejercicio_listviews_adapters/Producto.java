package com.example.bertiwi.ejercicio_listviews_adapters;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bertiwi on 15/11/2017.
 */

public class Producto implements Parcelable{
    private String tituloProducto;
    private int imageId;
    private int stock;

    public Producto(String tituloProducto, int imageId, int stock) {
        this.tituloProducto = tituloProducto;
        this.imageId = imageId;
        this.stock = stock;
    }

    protected Producto(Parcel in) {
        tituloProducto = in.readString();
        imageId = in.readInt();
        stock = in.readInt();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    public int getStock() {
        return stock;
    }

    public String getTituloProducto() {
        return tituloProducto;
    }

    public int getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tituloProducto);
        parcel.writeInt(imageId);
        parcel.writeInt(stock);
    }
}
