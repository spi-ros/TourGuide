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

        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.place_telaro), getString(R.string.info_telaro),
                R.drawable.telaro, getString(R.string.geo_telaro), getString(R.string.phone_telaro),
                getString(R.string.tag_fragmentF), getString(R.string.link_telaro),
                getString(R.string.food_tag_1)));

        places.add(new Place(getString(R.string.place_trata), getString(R.string.info_trata),
                R.drawable.trata, getString(R.string.geo_trata), getString(R.string.phone_trata),
                getString(R.string.tag_fragmentF), getString(R.string.link_trata),
                getString(R.string.food_tag_2)));

        places.add(new Place(getString(R.string.place_sushimou), getString(R.string.info_sushimou),
                R.drawable.sushimou, getString(R.string.geo_sushimou),
                getString(R.string.phone_sushimou), getString(R.string.tag_fragmentF),
                getString(R.string.link_sushimou), getString(R.string.food_tag_3)));

        places.add(new Place(getString(R.string.place_vassilenas),
                getString(R.string.info_vassilenas), R.drawable.vassilenas,
                getString(R.string.geo_vassilenas), getString(R.string.phone_vassilenas),
                getString(R.string.tag_fragmentF), getString(R.string.link_vassilenas),
                getString(R.string.food_tag_4)));

        places.add(new Place(getString(R.string.place_ifeel), getString(R.string.info_ifeel),
                R.drawable.ifeel, getString(R.string.geo_ifeel), getString(R.string.phone_ifeel),
                getString(R.string.tag_fragmentF), getString(R.string.link_ifeel),
                getString(R.string.food_tag_5)));

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
