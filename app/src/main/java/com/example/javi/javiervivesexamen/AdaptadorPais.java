package com.example.javi.javiervivesexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Javi on 21/02/2018.
 */

public class AdaptadorPais extends BaseAdapter {

    Context context;
    ArrayList<DatosPais> listaPais;

    public AdaptadorPais(Context context, ArrayList<DatosPais> listaPais) {
        this.context = context;
        this.listaPais = listaPais;
    }

    @Override
    public int getCount() {
        return listaPais.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPais.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista = view;
        LayoutInflater inflate =LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.item_pais, null);

        TextView tvNombre, tvClave, tvCapital, tvContinente, tvPoblacion, tvLatlng, tvFronteras;
        tvNombre = vista.findViewById(R.id.tvNombre);
        tvClave = vista.findViewById(R.id.tvClave);
        tvCapital = vista.findViewById(R.id.tvCapital);
        tvContinente = vista.findViewById(R.id.tvContinente);
        tvPoblacion = vista.findViewById(R.id.tvPoblacion);
        tvLatlng = vista.findViewById(R.id.tvLatlng);
        tvFronteras = vista.findViewById(R.id.tvFronteras);

        // IMPRIMO LOS VALORES DEL ARRAY LIST

        tvNombre.setText("Nombre: " + listaPais.get(i).getNombre().toString());
        tvClave.setText("Clave: " + listaPais.get(i).getClave().toString());
        tvCapital.setText("Capital: " + listaPais.get(i).getClave().toString());
        tvContinente.setText("Continente: " + listaPais.get(i).getClave().toString());
        tvPoblacion.setText("Población: " + listaPais.get(i).getClave().toString() + " habitantes");
        tvLatlng.setText("Latitud y longitud: " + listaPais.get(i).getClave().toString());
        tvFronteras.setText("Países fronterizos: " + listaPais.get(i).getClave().toString());

        return vista;
    }

}
