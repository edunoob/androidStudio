// Archivo: AdaptadorSelecciones.java
package com.example.conmebol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdaptadorSelecciones extends BaseAdapter {

    private final ArrayList<Seleccion> entradas;
    private final int R_layout_IdView;
    private final Context contexto;

    public AdaptadorSelecciones(Context contexto, int R_layout_IdView, ArrayList<Seleccion> entradas) {
        super();
        this.contexto = contexto;
        this.entradas = entradas;
        this.R_layout_IdView = R_layout_IdView;
    }

    // Devuelve el número total de elementos.
    @Override
    public int getCount() {
        return entradas.size();
    }

    // Devuelve el elemento en una posición dada.
    @Override
    public Object getItem(int posicion) {
        return entradas.get(posicion);
    }

    // Devuelve el ID de fila.
    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    // Crea y devuelve la vista de cada fila.
    @Override
    public View getView(int posicion, View view, ViewGroup parent) {
        View v = view;

        // Reutilización u inflación de la vista
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)
                    contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R_layout_IdView, parent, false);
        }

        // Obtener el objeto de datos
        Seleccion entrada = entradas.get(posicion);

        if (entrada != null) {
            // Asignar el logo (ID: itemLogo en item_seleccion.xml)
            ImageView logo = v.findViewById(R.id.itemLogo);
            if (logo != null) {
                logo.setImageResource(entrada.getIdLogo());
            }

            // Asignar el nombre (ID: itemNombre en item_seleccion.xml)
            TextView nombre = v.findViewById(R.id.itemNombre);
            if (nombre != null) {
                nombre.setText(entrada.getNombre());
            }

            // Asignar la información (ID: itemInfo en item_seleccion.xml)
            TextView info = v.findViewById(R.id.itemInfo);
            if (info != null) {
                info.setText(entrada.getInfo());
            }
        }

        return v;
    }
}