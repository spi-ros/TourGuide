package com.example.android.tourguide;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.graphics.Color.rgb;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    int elevation = 12;
    Context context;
    private int previousExpandedPosition = -1;
    private int mExpandedPosition = -1;
    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;
    private HotelsFragment fragmenth;
    private GeneralInfoFragment fragmentg;

    PlaceAdapter(FoodFragment fragmentF, List<Place> places, Context mContext) {
        this.places = places;
        this.fragmentf = fragmentF;
        this.context = mContext;
    }

    PlaceAdapter(SitesFragment fragmentS, List<Place> places, Context mContext) {
        this.places = places;
        this.fragments = fragmentS;
        this.context = mContext;
    }

    PlaceAdapter(HotelsFragment fragmentH, List<Place> places, Context mContext) {
        this.places = places;
        this.fragmenth = fragmentH;
        this.context = mContext;
    }

    PlaceAdapter(GeneralInfoFragment fragmentG, List<Place> places, Context mContext) {
        this.places = places;
        this.fragmentg = fragmentG;
        this.context = mContext;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final String fragmentTag = places.get(viewHolder.getAdapterPosition()).getFragmentTag();
        final String assistTag = places.get(viewHolder.getAdapterPosition()).getAssistTag();

        viewHolder.placeImageView.setImageResource(places.get(position).getPhoto());

        viewHolder.placeTextView.setText(places.get(position).getTitle());

        final boolean isExpanded = position == mExpandedPosition;
        if (fragmentTag.equals(context.getString(R.string.tag_fragmentS)) ||
                fragmentTag.equals(context.getString(R.string.tag_fragmentF)) ||
                fragmentTag.equals(context.getString(R.string.tag_fragmentH))) {

            viewHolder.placeTextView.setTextColor(rgb(236, 240, 241));
            viewHolder.generalTextView1.setVisibility(View.GONE);
            viewHolder.generalTextView2.setVisibility(View.GONE);
            viewHolder.generalTextView3.setVisibility(View.GONE);
            viewHolder.generalTextView4.setVisibility(View.GONE);
        } else {
            viewHolder.infoTextView.setVisibility(View.GONE);
            viewHolder.placeTextView.setTextColor(rgb(132, 117, 69));

            if (assistTag.equals(context.getString(R.string.generalInfo_tag_1))) {
                viewHolder.generalTextView1.setText(R.string.hospital_laiko);
                viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri hospitalUri = Uri.parse(context.getString(R.string.geo_laiko_hospital));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView2.setText(R.string.hospital_gennimatas);
                viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri hospitalUri = Uri.parse(context.getString(R.string.geo_genimatas_hospital));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView3.setText(R.string.hospital_ippokrateio);
                viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri hospitalUri = Uri.parse(context.getString(R.string.geo_ippokrateio_hospital));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView4.setText(R.string.hospital_evaggelismos);
                viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri hospitalUri = Uri.parse(context.getString(R.string.geo_evaggelismos_hospital));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });


            } else if (assistTag.equals(context.getString(R.string.generalInfo_tag_2))) {
                viewHolder.generalTextView1.setText(R.string.pharmacy_korres);
                viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri pharmacyUri = Uri.parse(context.getString(R.string.geo_korres_pharmacy));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView2.setText(R.string.pharmacy_mpakakos);
                viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri pharmacyUri = Uri.parse(context.getString(R.string.geo_mpakakos_pharmacy));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView3.setText(R.string.pharmacy_acropolis);
                viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri pharmacyUri = Uri.parse(context.getString(R.string.geo_acropolis_pharmacy));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

                viewHolder.generalTextView4.setText(R.string.pharmacy_athens_city);
                viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri pharmacyUri = Uri.parse(context.getString(R.string.geo_athensCity_pharmacy));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        fragmentg.startActivity(mapIntent);
                    }
                });

            } else if (assistTag.equals(context.getString(R.string.generalInfo_tag_3))) {
                viewHolder.generalTextView1.setText(R.string.athens_airport_taxi);
                viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                        phoneIntent.setData(Uri.parse(context.getString(R.string.phone_athensAirport_taxi)));
                        fragmentg.startActivity(phoneIntent);
                    }
                });

                viewHolder.generalTextView2.setText(R.string.taxi_transfer_athens);
                viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                        phoneIntent.setData(Uri.parse(context.getString(R.string.phone_transferAthens_taxi)));
                        fragmentg.startActivity(phoneIntent);
                    }
                });

                viewHolder.generalTextView3.setText(R.string.CitySightSeeing_athens);
                viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri linkUri = Uri.parse(context.getString(R.string.link_citySightSeeing));
                        Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);
                        fragmentg.startActivity(linkIntent);
                    }
                });

                viewHolder.generalTextView4.setText(R.string.public_bus_service);
                viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri linkUri = Uri.parse(context.getString(R.string.link_public_bus));
                        Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);
                        fragmentg.startActivity(linkIntent);
                    }
                });

            }
        }
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

        if (fragmentTag.equals(context.getString(R.string.tag_fragmentG))) {
            viewHolder.mapImageView.setVisibility(View.GONE);
        }

        viewHolder.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                switch (fragmentTag) {
                    case "fragmentS":
                        fragments.startActivity(mapIntent);
                        break;
                    case "fragmentF":
                        fragmentf.startActivity(mapIntent);
                        break;
                    case "fragmentH":
                        fragmenth.startActivity(mapIntent);
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

        if (fragmentTag.equals(context.getString(R.string.tag_fragmentG))) {
            viewHolder.phoneImageView.setVisibility(View.GONE);
        }

        viewHolder.phoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + places.get(viewHolder.getAdapterPosition()).getPhoneNumber()));

                switch (fragmentTag) {
                    case "fragmentS":
                        fragments.startActivity(phoneIntent);
                        break;
                    case "fragmentF":
                        fragmentf.startActivity(phoneIntent);
                        break;
                    case "fragmentH":
                        fragmenth.startActivity(phoneIntent);
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

        viewHolder.linkImageView.setBackgroundResource(R.drawable.ic_link_black);
        viewHolder.linkImageView.getBackground().setAlpha(150);

        if (fragmentTag.equals(context.getString(R.string.tag_fragmentG))) {
            viewHolder.linkImageView.setVisibility(View.GONE);
        }

        viewHolder.linkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri linkUri = Uri.parse(places.get(viewHolder.getAdapterPosition()).getLink());
                Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);

                switch (fragmentTag) {
                    case "fragmentS":
                        fragments.startActivity(linkIntent);
                        break;
                    case "fragmentF":
                        fragmentf.startActivity(linkIntent);
                        break;
                    case "fragmentH":
                        fragmenth.startActivity(linkIntent);
                        break;
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

        LinearLayout hiddenLayout;
        ImageView placeImageView, mapImageView, phoneImageView, linkImageView;
        TextView placeTextView, infoTextView, generalTextView1, generalTextView2, generalTextView3,
                generalTextView4;

        ViewHolder(View itemView) {
            super(itemView);
            placeImageView = itemView.findViewById(R.id.place_image_view);
            placeTextView = itemView.findViewById(R.id.place_text_view);
            infoTextView = itemView.findViewById(R.id.info_text_view);
            generalTextView1 = itemView.findViewById(R.id.general_text_view_1);
            generalTextView2 = itemView.findViewById(R.id.general_text_view_2);
            generalTextView3 = itemView.findViewById(R.id.general_text_view_3);
            generalTextView4 = itemView.findViewById(R.id.general_text_view_4);
            mapImageView = itemView.findViewById(R.id.map_image_view);
            phoneImageView = itemView.findViewById(R.id.phone_image_view);
            linkImageView = itemView.findViewById(R.id.link_image_view);
            hiddenLayout = itemView.findViewById(R.id.hidden_layout);
        }
    }
}
