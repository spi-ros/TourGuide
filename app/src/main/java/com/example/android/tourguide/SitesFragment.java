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
public class SitesFragment extends Fragment {


    public SitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.recycler, container, false);

        final ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("Gardenia Wilson", "25 years old", R.drawable.gardenia));
        persons.add(new Person("Orchid Maiss", "23 years old", R.drawable.orchid));
        persons.add(new Person("Rose Watts", "35 years old", R.drawable.rose));
        persons.add(new Person("Gardenia Wilson", "25 years old", R.drawable.gardenia));
        persons.add(new Person("Orchid Maiss", "23 years old", R.drawable.orchid));
        persons.add(new Person("Rose Watts", "35 years old", R.drawable.rose));
        persons.add(new Person("Gardenia Wilson", "25 years old", R.drawable.gardenia));
        persons.add(new Person("Orchid Maiss", "23 years old", R.drawable.orchid));
        persons.add(new Person("Rose Watts", "35 years old", R.drawable.rose));

        // Sort persons Alphabetically by Age
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge().compareToIgnoreCase(p2.getAge());
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(persons);

        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
