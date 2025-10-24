package com.example.conmebol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorSelecciones extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Seleccion> selecciones;
    private int selectedPosition = -1; // posición seleccionada para RadioButton

    public AdaptadorSelecciones(Context context, int layout, ArrayList<Seleccion> selecciones) {
        this.context = context;
        this.layout = layout;
        this.selecciones = selecciones;
    }

    @Override
    public int getCount() {
        return selecciones.size();
    }

    @Override
    public Object getItem(int position) {
        return selecciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView logo;
        TextView nombre;
        TextView info;
        RadioButton radio;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.logo = convertView.findViewById(R.id.itemLogo);
            holder.nombre = convertView.findViewById(R.id.itemNombre);
            holder.info = convertView.findViewById(R.id.itemInfo);
            holder.radio = convertView.findViewById(R.id.itemRadio);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Seleccion seleccion = selecciones.get(position);
        holder.logo.setImageResource(seleccion.getIdLogo());
        holder.nombre.setText(seleccion.getNombre());
        holder.info.setText(seleccion.getInfo());

        // Manejo del RadioButton
        holder.radio.setChecked(position == selectedPosition);

        // Selección al hacer clic en el item completo
        convertView.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();
        });

        return convertView;
    }
}