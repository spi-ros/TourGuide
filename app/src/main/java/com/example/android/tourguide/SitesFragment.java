package com.example.android.tourguide;


import android.content.Intent;
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
public class SitesFragment extends Fragment {


    public SitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.temple_of_poseidon), getString(R.string.info_temple_of_poseidon), R.drawable.temple_of_poseidon, "geo:37.650371, 24.024608?z=17"));
        places.add(new Place(getString(R.string.acropolis_of_athens), getString(R.string.info_acropolis_of_athens), R.drawable.acropolis_of_athens, "geo:37.971566, 23.725749?z=17"));
        places.add(new Place(getString(R.string.odeon_of_herodes_atticus), getString(R.string.info_odeon_herodes_atticus), R.drawable.odeon_of_herodes_atticus, "geo:37.970822, 23.724580?z=17"));
        places.add(new Place(getString(R.string.ancient_agora_of_athens), getString(R.string.info_agora_of_athens), R.drawable.ancient_agora_of_athens, "geo:37.974692, 23.721991?z=17"));
        places.add(new Place(getString(R.string.monastiraki), getString(R.string.info_monastiraki), R.drawable.monastiraki, "geo:37.976390, 23.725875?z=17"));
        places.add(new Place(getString(R.string.kerameikos), getString(R.string.info_kerameikos), R.drawable.kerameikos, "geo:37.978406, 23.718979?z=17"));
        places.add(new Place(getString(R.string.temple_of_olympian_zeus), getString(R.string.info_olympian_zeus), R.drawable.temple_of_olympian_zeus, "geo:37.969325, 23.733089"));

        // Sort places Alphabetically by Age
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return p1.getInformation().compareToIgnoreCase(p2.getInformation());
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(this, places);

        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
