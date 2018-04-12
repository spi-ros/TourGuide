package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private int mExpandedPosition = -1;
    int previousExpandedPosition = -1;


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView personName;
        TextView infoTextView;
        ImageView mapImageView;
        ImageView personPhoto;
        View details;

        ViewHolder(View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.person_name);
            infoTextView = itemView.findViewById(R.id.info_text_view);
            personPhoto = itemView.findViewById(R.id.person_photo);
            details = itemView.findViewById(R.id.details_layout);
            mapImageView = itemView.findViewById(R.id.map_image_view);

        }

    }

    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;

    public RecyclerAdapter( FoodFragment fragmentF, List<Place> places){
        this.places = places;
        this.fragmentf = fragmentF;
    }

    public RecyclerAdapter( SitesFragment fragmentS, List<Place> places){
        this.places = places;
        this.fragments = fragmentS;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        viewHolder.personName.setText(places.get(position).getTitle());
        viewHolder.infoTextView.setText(places.get(position).getInformation());
        viewHolder.personPhoto.setImageResource(places.get(position).getPhoto());

        final boolean isExpanded = position==mExpandedPosition;
        viewHolder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        viewHolder.itemView.setActivated(isExpanded);

        if (isExpanded)
            previousExpandedPosition = viewHolder.getAdapterPosition();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:viewHolder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });

        viewHolder.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                fragmentf.startActivity(mapIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
