package com.example.android.tourguide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

        places.add(new Place(getString(R.string.place_poseidon), getString(R.string.info_poseidon),
                R.drawable.temple_of_poseidon, getString(R.string.geo_poseidon),
                getString(R.string.phone_poseidon), getString(R.string.tag_fragmentS),
                getString(R.string.link_poseidon), getString(R.string.sites_tag_1)));

        places.add(new Place(getString(R.string.place_acropolis), getString(R.string.info_acropolis),
                R.drawable.acropolis_of_athens, getString(R.string.geo_acropolis),
                getString(R.string.phone_acropolis), getString(R.string.tag_fragmentS),
                getString(R.string.link_acropolis), getString(R.string.sites_tag_2)));

        places.add(new Place(getString(R.string.place_odeon), getString(R.string.info_odeon),
                R.drawable.odeon_of_herodes_atticus, getString(R.string.geo_odeon),
                getString(R.string.phone_odeon), getString(R.string.tag_fragmentS),
                getString(R.string.link_odeon), getString(R.string.sites_tag_3)));

        places.add(new Place(getString(R.string.place_agora), getString(R.string.info_agora),
                R.drawable.ancient_agora_of_athens, getString(R.string.geo_agora),
                getString(R.string.phone_agora), getString(R.string.tag_fragmentS),
                getString(R.string.link_agora), getString(R.string.sites_tag_4)));

        places.add(new Place(getString(R.string.place_monastiraki),
                getString(R.string.info_monastiraki), R.drawable.monastiraki,
                getString(R.string.geo_monastiraki), getString(R.string.phone_monastiraki),
                getString(R.string.tag_fragmentS), getString(R.string.link_monastiraki),
                getString(R.string.sites_tag_5)));

        places.add(new Place(getString(R.string.place_zeus), getString(R.string.info_olympian_zeus),
                R.drawable.temple_of_olympian_zeus, getString(R.string.geo_zeus),
                getString(R.string.phone_zeus), getString(R.string.tag_fragmentS),
                getString(R.string.link_zeus), getString(R.string.sites_tag_6)));

        // Sort places Alphabetically by Age
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return p1.getTitle().compareToIgnoreCase(p2.getTitle());
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
