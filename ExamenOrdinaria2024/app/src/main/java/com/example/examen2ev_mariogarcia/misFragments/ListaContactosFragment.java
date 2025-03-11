package com.example.examen2ev_mariogarcia.misFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.examen2ev_mariogarcia.Contact;
import com.example.examen2ev_mariogarcia.ContactAdapter;
import com.example.examen2ev_mariogarcia.R;

import java.util.ArrayList;
import java.util.List;

public class ListaContactosFragment extends Fragment {

    private GridView gridViewContacts;

    public ListaContactosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View root = inflater.inflate(R.layout.fragment_lista_contactos, container, false);

        // Inicializar el GridView
        gridViewContacts = root.findViewById(R.id.gridViewContacts);

        // Crear lista de contactos con los datos proporcionados
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.ic_person, "Mario García", "123-456-7890", "mario@mejoralumno"));
        contacts.add(new Contact(R.drawable.ic_person, "Cristiano Ronaldo", "000-000-0000", "cris@suuu.com"));
        contacts.add(new Contact(R.drawable.ic_person, "Madison Beer", "666-666-6666", "maddy@check.com"));
        contacts.add(new Contact(R.drawable.ic_person, "Laura Sacristán", "111-111-1111", "laura@profe.com"));

        // Configurar adaptador y asignarlo al GridView
        ContactAdapter adapter = new ContactAdapter(getContext(), contacts);
        gridViewContacts.setAdapter(adapter);

        // Configurar el listener para los clics en los elementos del GridView
        gridViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el contacto pulsado
                Contact clickedContact = contacts.get(position);

                // Mostrar un Toast con el nombre del contacto
                Toast.makeText(getContext(), "Has pulsado el contacto: " + clickedContact.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
