package com.example.fragmentoestatico;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class PrimerFragmento extends Fragment {

    public interface OnItemSelectedListener {
        void onItemSelected(int imageResource);
    }

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primer_fragmento, container, false);

        ListView listView = view.findViewById(R.id.listView);
        String[] frutas = {"Manzana", "Pera", "Platano"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, frutas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            int[] images = {R.drawable.manzana, R.drawable.pera, R.drawable.platano};
            if (listener != null) listener.onItemSelected(images[position]);
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        }
    }
}
