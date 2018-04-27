package com.example.android.tourguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    int previousExpandedPosition = -1;
    private int mExpandedPosition = -1;
    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;
    float elevation = 12;

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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        viewHolder.placeImageView.setImageResource(places.get(position).getPhoto());

        viewHolder.placeTextView.setText(places.get(position).getTitle());

        final boolean isExpanded = position == mExpandedPosition;
        viewHolder.infoTextView.setText(places.get(position).getInformation());
        viewHolder.hiddenLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        viewHolder.itemView.setActivated(isExpanded);

        if (isExpanded)
            previousExpandedPosition = viewHolder.getAdapterPosition();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1 : viewHolder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(viewHolder.getAdapterPosition());
                viewHolder.cardView.setCardElevation(elevation);
            }
        });

        viewHolder.mapImageView.setBackgroundResource(R.drawable.ic_place_white);
        viewHolder.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = places.get(viewHolder.getAdapterPosition()).getTag();

                Uri gmmIntentUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (tag.equals("fragmentS")) {
                    fragments.startActivity(mapIntent);
                } else {
                    fragmentf.startActivity(mapIntent);
                }
            }
        });

        viewHolder.mapImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        viewHolder.mapImageView.setImageResource(R.drawable.ic_place_black);
                        break;
                    case MotionEvent.ACTION_UP :
                        viewHolder.mapImageView.setImageResource(R.drawable.ic_place_white);
                        break;
                }
                return false;
            }
        });

        viewHolder.phoneImageView.setBackgroundResource(R.drawable.ic_phone_white);
        viewHolder.phoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = places.get(viewHolder.getAdapterPosition()).getTag();

                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + places.get(viewHolder.getAdapterPosition()).getPhoneNumber()));

                if (tag.equals("fragmentS")) {
                    fragments.startActivity(phoneIntent);
                } else {
                    fragmentf.startActivity(phoneIntent);
                }
            }
        });

        viewHolder.phoneImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        viewHolder.phoneImageView.setImageResource(R.drawable.ic_phone_black);
                        break;
                    case MotionEvent.ACTION_UP :
                        viewHolder.phoneImageView.setImageResource(R.drawable.ic_phone_white);
                        break;
                }
                return false;
            }
        });

        viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_white);
        viewHolder.galleryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = places.get(viewHolder.getAdapterPosition()).getTag();

                Intent photoIntent = new Intent();
                photoIntent.setClass(v.getContext(), SecondActivity.class);
                photoIntent.putExtra("testString", places.get(viewHolder.getAdapterPosition()).getGalleryTag());


                if (tag.equals("fragmentS")) {
                    fragments.startActivity(photoIntent);
                } else {
                    Toast.makeText(v.getContext(), "There are not any photos for this place.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewHolder.galleryImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        viewHolder.galleryImageView.setImageResource(R.drawable.ic_photo_library_black);
                        break;
                    case MotionEvent.ACTION_UP :
                        viewHolder.galleryImageView.setImageResource(R.drawable.ic_photo_library_white);
                        break;
                }
                return false;
            }
        });

        viewHolder.linkImageView.setBackgroundResource(R.drawable.ic_link_white);
        viewHolder.linkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = places.get(viewHolder.getAdapterPosition()).getTag();

                Uri linkUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLink());
                Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);

                if (tag.equals("fragmentS")) {
                    fragments.startActivity(linkIntent);
                } else {
                    fragmentf.startActivity(linkIntent);
                }
            }
        });

        viewHolder.linkImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        viewHolder.linkImageView.setImageResource(R.drawable.ic_link_black);
                        break;
                    case MotionEvent.ACTION_UP :
                        viewHolder.linkImageView.setImageResource(R.drawable.ic_link_white);
                        break;
                }
                return false;
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

        ImageView placeImageView;
        TextView placeTextView;
        ImageView mapImageView;
        ImageView phoneImageView;
        ImageView galleryImageView;
        ImageView linkImageView;
        TextView infoTextView;
        CardView cardView;
        LinearLayout hiddenLayout;

        ViewHolder(View itemView) {
            super(itemView);
            placeImageView = itemView.findViewById(R.id.place_image_view);
            placeTextView = itemView.findViewById(R.id.place_text_view);
            infoTextView = itemView.findViewById(R.id.info_text_view);
            mapImageView = itemView.findViewById(R.id.map_image_view);
            phoneImageView = itemView.findViewById(R.id.phone_image_view);
            galleryImageView = itemView.findViewById(R.id.gallery_image_view);
            linkImageView = itemView.findViewById(R.id.link_image_view);
            cardView = itemView.findViewById(R.id.cv);
            hiddenLayout = itemView.findViewById(R.id.hidden_layout);

        }

    }
}
