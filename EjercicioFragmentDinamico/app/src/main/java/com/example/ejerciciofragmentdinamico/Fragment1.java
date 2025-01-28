package com.example.ejerciciofragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    public interface OnButtonClickListener {
        void onButtonClick(int viewId);
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public View.OnClickListener listener;

    public Button getBotonManzana() {
        return botonManzana;
    }

    public void setBotonManzana(Button botonManzana) {
        this.botonManzana = botonManzana;
    }

    public Button getBotonPera() {
        return botonPera;
    }

    public void setBotonPera(Button botonPera) {
        this.botonPera = botonPera;
    }

    public Button getBotonPlatano() {
        return botonPlatano;
    }

    public void setBotonPlatano(Button botonPlatano) {
        this.botonPlatano = botonPlatano;
    }

    static Button botonManzana;
    static Button botonPera;
    static Button botonPlatano;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        botonManzana = view.findViewById(R.id.buttonManzana);
        botonManzana.setOnClickListener(v -> notifyActivity(R.id.buttonManzana));
        botonPera = view.findViewById(R.id.buttonPera);
        botonPera.setOnClickListener(v -> notifyActivity(R.id.buttonPera));
        botonPlatano = view.findViewById(R.id.buttonPlatano);
        botonPlatano.setOnClickListener(v -> notifyActivity(R.id.buttonPlatano));

        return view;
    }

    private void notifyActivity(int buttonId) {
        ((MainActivity) requireActivity()).changeFragment(buttonId);
    }

}