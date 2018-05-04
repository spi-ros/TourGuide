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
public class GeneralInfoFragment extends Fragment {


    public GeneralInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.hospitals), "nought",
                R.drawable.red_cross, "nought", "nought",
                getString(R.string.tag_fragmentG), "nought", getString(R.string.generalInfo_tag_1)));

        places.add(new Place(getString(R.string.pharmacies), "nought",
                R.drawable.pharmacy, "nought", "nought",
                getString(R.string.tag_fragmentG), "nought", getString(R.string.generalInfo_tag_2)));

        places.add(new Place(getString(R.string.transport), "nought",
                R.drawable.transport, "nought", "nought",
                getString(R.string.tag_fragmentG), "nought", getString(R.string.generalInfo_tag_3)));

        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return p1.getTitle().compareToIgnoreCase(p2.getTitle());
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        PlaceAdapter adapter = new PlaceAdapter(this, places);

        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
