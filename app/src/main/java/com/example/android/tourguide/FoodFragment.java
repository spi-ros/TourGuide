package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place("Gardenia Wilson", getString(R.string.info_temple_of_poseidon), R.drawable.temple_of_poseidon));
        places.add(new Place("Orchid Maiss", "23 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Rose Watts", "35 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Gardenia Wilson", "25 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Orchid Maiss", "23 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Rose Watts", "35 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Gardenia Wilson", "25 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Orchid Maiss", "23 years old", R.drawable.temple_of_poseidon));
        places.add(new Place("Rose Watts", "35 years old", R.drawable.temple_of_poseidon));

        // Sort places Alphabetically by Name
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return p1.getTitle().compareToIgnoreCase(p2.getTitle());
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(this,places);

        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
