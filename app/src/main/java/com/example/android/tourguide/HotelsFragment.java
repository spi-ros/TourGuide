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
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.place_grande_bretagne),
                getString(R.string.info_grande_bretagne), R.drawable.grande_bretagne,
                getString(R.string.geo_grande_bretagne), getString(R.string.phone_grande_bretagne),
                getString(R.string.tag_fragmentH), getString(R.string.link_grande_bretagne),
                getString(R.string.hotels_tag_1)));

        places.add(new Place(getString(R.string.place_king_george),
                getString(R.string.info_king_george), R.drawable.king_george,
                getString(R.string.geo_king_george), getString(R.string.phone_king_george),
                getString(R.string.tag_fragmentH), getString(R.string.link_king_george),
                getString(R.string.hotels_tag_2)));

        places.add(new Place(getString(R.string.place_herodion_hotel),
                getString(R.string.info_herodion_hotel), R.drawable.herodion_hotel,
                getString(R.string.geo_herodion_hotel), getString(R.string.phone_herodion_hotel),
                getString(R.string.tag_fragmentH), getString(R.string.link_herodion_hotel),
                getString(R.string.hotels_tag_3)));

        places.add(new Place(getString(R.string.place_hilton), getString(R.string.info_hilton),
                R.drawable.hilton_athens, getString(R.string.geo_hilton),
                getString(R.string.phone_hilton), getString(R.string.tag_fragmentH),
                getString(R.string.link_hilton), getString(R.string.hotels_tag_4)));

        places.add(new Place(getString(R.string.place_st_george_lycabettus),
                getString(R.string.info_st_george_lycabettus), R.drawable.st_george_lycabettus,
                getString(R.string.geo_st_george_lycabettus),
                getString(R.string.phone_st_george_lycabettus),
                getString(R.string.tag_fragmentH), getString(R.string.link_st_george_lycabettus),
                getString(R.string.hotels_tag_5)));

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
