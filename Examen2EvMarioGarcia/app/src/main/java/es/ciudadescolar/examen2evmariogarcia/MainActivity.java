package es.ciudadescolar.examen2evmariogarcia;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = findViewById(R.id.gridView);
        contacts = new ArrayList<>();

        contacts.add(new Contact(R.drawable.ic_launcher_foreground, "Mario García", "123-456-7890", "mario@mejoralumno"));
        contacts.add(new Contact(R.drawable.ic_launcher_foreground, "Cristiano Ronaldo", "000-000-0000", "cris@suuu.com"));
        contacts.add(new Contact(R.drawable.ic_launcher_foreground, "Madison Beer", "666-666-6666", "maddy@check.com"));
        contacts.add(new Contact(R.drawable.ic_launcher_foreground, "Laura Sacristán", "111-111-1111", "laura@profe.com"));

        ContactAdapter adapter = new ContactAdapter(this, contacts);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Has pulsado el contacto " + contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        TextView textView = findViewById(R.id.textView);

        if (id == R.id.listado_contactos) {
            gridView.setVisibility(android.view.View.VISIBLE);
        } else if (id == R.id.notificacion) {
            Toast.makeText(this, "Has seleccionado Notificación", Toast.LENGTH_SHORT).show();
            gridView.setVisibility(android.view.View.GONE);
        } else if (id == R.id.alarma) {
            Toast.makeText(this, "Has seleccionado Alarma", Toast.LENGTH_SHORT).show();
            gridView.setVisibility(android.view.View.GONE);
        } else if (id == R.id.calculo_nota) {
            Toast.makeText(this, "Has seleccionado Cálculo Nota", Toast.LENGTH_SHORT).show();
            gridView.setVisibility(android.view.View.GONE);
        } else if (id == R.id.examen) {
            textView.setVisibility(android.view.View.GONE);
            //Toast.makeText(this, "Has seleccionado Examen Mario_García", Toast.LENGTH_SHORT).show();
            //gridView.setVisibility(android.view.View.GONE);
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}
