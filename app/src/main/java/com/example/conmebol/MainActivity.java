package com.example.conmebol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Vista para el pie de página
        TextView footerText = findViewById(R.id.footer_text);

        // 2. Crear la lista de selecciones
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        selecciones.add(new Seleccion("Brasil FC", "Brazuca, 5 copas del mundo", R.drawable.brasil));
        selecciones.add(new Seleccion("Argentina FC", "La albiceleste, 3 copas del mundo", R.drawable.argentina));
        selecciones.add(new Seleccion("Uruguay FC", "La garra charrúa, 2 copas del mundo", R.drawable.uruguay));
        selecciones.add(new Seleccion("Perú FC", "La bicolor, corazón y garra", R.drawable.peru));
        selecciones.add(new Seleccion("Colombia FC", "La tricolor, pasión y sabor", R.drawable.colombia));

        // 3. Crear adaptador
        AdaptadorSelecciones adaptador = new AdaptadorSelecciones(this, R.layout.item_seleccion, selecciones);

        // 4. Enlazar ListView
        ListView lista = findViewById(R.id.listViewSelecciones);
        lista.setAdapter(adaptador);

        // 5. Actualizar el pie de página al hacer clic
        lista.setOnItemClickListener((parent, view, position, id) -> {
            Seleccion seleccionada = (Seleccion) parent.getItemAtPosition(position);
            footerText.setText("Has seleccionado a " + seleccionada.getNombre());
        });
    }
}