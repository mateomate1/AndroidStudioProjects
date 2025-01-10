package com.example.routetogether;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Rutas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rutas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView lista;
    List<Ruta> rutaList;

    public Rutas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Rutas.
     */
    // TODO: Rename and change types and number of parameters
    public static Rutas newInstance(String param1, String param2) {
        Rutas fragment = new Rutas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lista = (ListView) getView().findViewById(R.id.list_rutas);
        rutaList = new ArrayList<>();
        boolean[] dias = {true,true,true,true,true,false,false};
        boolean[] dias1 = {true, false, false, false, true, true, false};
        boolean[] dias2 = {true, true, true, true, true, true, false};
        boolean[] dias3 = {false, false, false, false, false, true, true};
        boolean[] dias4 = {false, false, false, false, false, false, true};

        rutaList.add(new Ruta("coche", "Casa a Uni", "C/ Imaginacion 123", "C/ Universidad X", dias, "08:30"));
        rutaList.add(new Ruta("bici", "Vuelta ciclista", "C/ Ejemplo 456", "Parque Central", dias3, "09:00"));
        rutaList.add(new Ruta("bus", "Centro Comercial", "Calle Luna 100", "Centro Comercial Mall", dias1, "16:00"));
        rutaList.add(new Ruta("tren", "Estación a Montaña", "Estación Central", "Estación Montaña", dias2, "08:00"));
        rutaList.add(new Ruta("viaandante", "Caminata Sendero", "Inicio Sendero", "Final Sendero", dias4, "15:30"));
        AdaptadorRuta adaptador = new AdaptadorRuta(
                this,
                R.layout.layout_rutas,
                rutaList
        );
        lista.setAdapter(adaptador);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rutas, container, false);
    }
}