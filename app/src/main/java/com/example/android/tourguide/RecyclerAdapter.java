package com.example.android.tourguide;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    int elevation = 12;
    private int previousExpandedPosition = -1;
    private int mExpandedPosition = -1;
    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;
    private HotelsFragment fragmenth;
    private GeneralInfoFragment fragmentg;

    RecyclerAdapter(FoodFragment fragmentF, List<Place> places) {
        this.places = places;
        this.fragmentf = fragmentF;
    }

    RecyclerAdapter(SitesFragment fragmentS, List<Place> places) {
        this.places = places;
        this.fragments = fragmentS;
    }

    RecyclerAdapter(HotelsFragment fragmentH, List<Place> places) {
        this.places = places;
        this.fragmenth = fragmentH;
    }

    RecyclerAdapter(GeneralInfoFragment fragmentG, List<Place> places) {
        this.places = places;
        this.fragmentg = fragmentG;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final String tag = places.get(viewHolder.getAdapterPosition()).getTag();

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
            }
        });

        viewHolder.mapImageView.setBackgroundResource(R.drawable.ic_place_black);
        viewHolder.mapImageView.getBackground().setAlpha(150);
        viewHolder.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                switch (tag) {
                    case "fragmentS":
                        fragments.startActivity(mapIntent);
                        break;
                    case "fragmentF":
                        fragmentf.startActivity(mapIntent);
                        break;
                    case "fragmentH":
                        fragmenth.startActivity(mapIntent);
                        break;
                    default:
                        fragmentg.startActivity(mapIntent);
                        break;
                }
            }
        });

        viewHolder.mapImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        viewHolder.mapImageView.setBackgroundResource(R.drawable.ic_place_white);
                        break;
                    case MotionEvent.ACTION_UP:
                        viewHolder.mapImageView.setBackgroundResource(R.drawable.ic_place_black);
                        break;
                }
                return false;
            }
        });

        viewHolder.phoneImageView.setBackgroundResource(R.drawable.ic_phone_black);
        viewHolder.phoneImageView.getBackground().setAlpha(150);
        viewHolder.phoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + places.get(viewHolder.getAdapterPosition()).getPhoneNumber()));

                switch (tag) {
                    case "fragmentS":
                        fragments.startActivity(phoneIntent);
                        break;
                    case "fragmentF":
                        fragmentf.startActivity(phoneIntent);
                        break;
                    case "fragmentH":
                        fragmenth.startActivity(phoneIntent);
                        break;
                    default:
                        fragmentg.startActivity(phoneIntent);
                        break;
                }
            }
        });

        viewHolder.phoneImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        viewHolder.phoneImageView.setBackgroundResource(R.drawable.ic_phone_white);
                        break;
                    case MotionEvent.ACTION_UP:
                        viewHolder.phoneImageView.setBackgroundResource(R.drawable.ic_phone_black);
                        break;
                }
                return false;
            }
        });

        viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_black);
        viewHolder.galleryImageView.getBackground().setAlpha(150);

        if (tag.equals("fragmentF") || tag.equals("fragmentH") || tag.equals("fragmentG")) {
            viewHolder.galleryImageView.setVisibility(View.GONE);
        }

        viewHolder.galleryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                if (tag.equals("fragmentS")) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_white);
                            break;
                        case MotionEvent.ACTION_UP:
                            viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_black);
                            break;
                    }
                }
                return false;
            }
        });

        viewHolder.linkImageView.setBackgroundResource(R.drawable.ic_link_black);
        viewHolder.linkImageView.getBackground().setAlpha(150);

        if (tag.equals("fragmentG")) {
            viewHolder.linkImageView.setVisibility(View.GONE);
        }

        viewHolder.linkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri linkUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLink());
                Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);

                if (tag.equals("fragmentS")) {
                    fragments.startActivity(linkIntent);
                } else if (tag.equals("fragmentF")) {
                    fragmentf.startActivity(linkIntent);
                } else if (tag.equals("fragmentH")) {
                    fragmenth.startActivity(linkIntent);
                } else {
                    fragmentg.startActivity(linkIntent);
                }
            }
        });

        viewHolder.linkImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        viewHolder.linkImageView.setBackgroundResource(R.drawable.ic_link_white);
                        break;
                    case MotionEvent.ACTION_UP:
                        viewHolder.linkImageView.setBackgroundResource(R.drawable.ic_link_black);
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
//        CardView cardView;
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
//            cardView = itemView.findViewById(R.id.cv);
            hiddenLayout = itemView.findViewById(R.id.hidden_layout);
        }
    }
}
