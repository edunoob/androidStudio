// Archivo: MainActivity.java
package com.example.conmebol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml debe contener solo el ListView
        setContentView(R.layout.activity_main);

        // 1. Crear la fuente de datos (ArrayList de objetos Seleccion)
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        selecciones.add(new Seleccion("Brasil FC", "Brazuca, 5 copas del mundo", R.drawable.brasil));
        selecciones.add(new Seleccion("Argentina FC", "La albiceleste, 3 copas del mundo", R.drawable.argentina));
        selecciones.add(new Seleccion("Uruguay FC", "La garra charrúa, 2 copas del mundo", R.drawable.uruguay));
        selecciones.add(new Seleccion("Perú FC", "La bicolor, corazón y garra", R.drawable.peru));
        selecciones.add(new Seleccion("Colombia FC", "La tricolor, pasión y sabor", R.drawable.colombia));

        // 2. Crear el Adaptador (usa R.layout.item_seleccion como diseño de cada fila)
        AdaptadorSelecciones adaptador = new AdaptadorSelecciones(this, R.layout.item_seleccion, selecciones);

        // 3. Enlazar el ListView usando el ID: listViewSelecciones
        ListView lista = findViewById(R.id.listViewSelecciones);
        lista.setAdapter(adaptador);

        // 4. Configurar la acción al hacer clic en una fila
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Se obtiene el objeto Seleccion en la posición clicada
                Seleccion seleccionada = (Seleccion) parent.getItemAtPosition(position);

                // Muestra el Toast con la información
                String mensaje = "Has seleccionado a " + seleccionada.getNombre() + ". Info: " + seleccionada.getInfo();
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}