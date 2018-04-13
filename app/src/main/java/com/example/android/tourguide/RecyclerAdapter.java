package com.example.android.tourguide;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
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

    int previousExpandedPosition = -1;
    private int mExpandedPosition = -1;
    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;
    private Fragment mFragment;
    public RecyclerAdapter(FoodFragment fragmentF, List<Place> places) {
        this.places = places;
        this.fragmentf = fragmentF;
    }

    public RecyclerAdapter(SitesFragment fragmentS, List<Place> places) {
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

        final boolean isExpanded = position == mExpandedPosition;
        viewHolder.details.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        viewHolder.itemView.setActivated(isExpanded);

        if (isExpanded)
            previousExpandedPosition = viewHolder.getAdapterPosition();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1 : viewHolder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });

        viewHolder.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri u1 = Uri.parse("geo:37.650371, 24.024608?z=17");
                Uri u2 = Uri.parse("geo:37.971566, 23.725749?z=17");
                Uri u3 = Uri.parse("geo:37.970822, 23.724580?z=17");
                Uri u4 = Uri.parse("geo:37.974692, 23.721991?z=17");
                Uri u5 = Uri.parse("geo:37.976390, 23.725875?z=17");
                Uri u6 = Uri.parse("geo:37.978406, 23.718979?z=17");
                Uri u7 = Uri.parse("geo:37.969325, 23.733089");

                Uri gmmIntentUri = Uri.parse(places.get(position).getLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (gmmIntentUri.equals(u1) || gmmIntentUri.equals(u2)
                        || gmmIntentUri.equals(u2) || gmmIntentUri.equals(u3)
                        || gmmIntentUri.equals(u4) || gmmIntentUri.equals(u5) || gmmIntentUri.equals(u6) || gmmIntentUri.equals(u7)) {
                    fragments.startActivity(mapIntent);
                } else {
                    fragmentf.startActivity(mapIntent);
                }
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

    static class ViewHolder extends RecyclerView.ViewHolder {

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
}
