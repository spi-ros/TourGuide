package com.example.android.tourguide;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
    private int previousExpandedPosition = -1;
    private int mExpandedPosition = -1;
    private List<Place> places;
    private FoodFragment fragmentf;
    private SitesFragment fragments;
    private HotelsFragment fragmenth;
    private GeneralInfoFragment fragmentg;

    PlaceAdapter(FoodFragment fragmentF, List<Place> places) {
        this.places = places;
        this.fragmentf = fragmentF;
    }

    PlaceAdapter(SitesFragment fragmentS, List<Place> places) {
        this.places = places;
        this.fragments = fragmentS;
    }

    PlaceAdapter(HotelsFragment fragmentH, List<Place> places) {
        this.places = places;
        this.fragmenth = fragmentH;
    }

    PlaceAdapter(GeneralInfoFragment fragmentG, List<Place> places) {
        this.places = places;
        this.fragmentg = fragmentG;
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

        final String tag = places.get(viewHolder.getAdapterPosition()).getTag();
        final String tag1 = places.get(viewHolder.getAdapterPosition()).getGalleryTag();

        viewHolder.placeImageView.setImageResource(places.get(position).getPhoto());

        viewHolder.placeTextView.setText(places.get(position).getTitle());

        final boolean isExpanded = position == mExpandedPosition;
        if (tag.equals("fragmentS") || tag.equals("fragmentF") || tag.equals("fragmentH")) {
            viewHolder.placeTextView.setTextColor(rgb(236, 240, 241));
            viewHolder.generalTextView1.setVisibility(View.GONE);
            viewHolder.generalTextView2.setVisibility(View.GONE);
            viewHolder.generalTextView3.setVisibility(View.GONE);
            viewHolder.generalTextView4.setVisibility(View.GONE);
        } else {
            viewHolder.infoTextView.setVisibility(View.GONE);
            viewHolder.placeTextView.setTextColor(rgb(132, 117, 69));

            switch (tag1) {
                case "generalInfo_tag_1":
                    viewHolder.generalTextView1.setText(R.string.hospital_laiko);
                    viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri hospitalUri = Uri.parse("geo:0,0?q= Laikο General Hospital of Athens");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView2.setText(R.string.hospital_gennimatas);
                    viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri hospitalUri = Uri.parse("geo:0,0?q= General Hospital of Athens \"G. Gennimatas\"");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView3.setText(R.string.hospital_ippokrateio);
                    viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri hospitalUri = Uri.parse("geo:0,0?q= \"Ippokrateio\" General Hospital of Athens");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView4.setText(R.string.hospital_evaggelismos);
                    viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri hospitalUri = Uri.parse("geo:0,0?q= Evaggelismos General Hospital");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, hospitalUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    break;
                case "generalInfo_tag_2":
                    viewHolder.generalTextView1.setText(R.string.pharmacy_korres);
                    viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri pharmacyUri = Uri.parse("geo:0,0?q= Korres Pharmacy, Eratosthenous ke Ivikou, Athina 116 35, Greece");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView2.setText(R.string.pharmacy_mpakakos);
                    viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri pharmacyUri = Uri.parse("geo:0,0?q= Georgios Mpakakos ΜΠΑΚΆΚΟΣ ΓΕΏΡΓΙΟΣ ");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView3.setText(R.string.pharmacy_acropolis);
                    viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri pharmacyUri = Uri.parse("geo:0,0?q= Ακρόπολις Φαρμακείο");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });

                    viewHolder.generalTextView4.setText(R.string.pharmacy_athens_city);
                    viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri pharmacyUri = Uri.parse("geo:0,0?q=  Themidos 1, Athina 105 54, Greece");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, pharmacyUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            fragmentg.startActivity(mapIntent);
                        }
                    });
                    break;
                case "generalInfo_tag_3":
                    viewHolder.generalTextView1.setText(R.string.athens_airport_taxi);
                    viewHolder.generalTextView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                            phoneIntent.setData(Uri.parse("tel: +30 21 1800 9110"));
                            fragmentg.startActivity(phoneIntent);
                        }
                    });

                    viewHolder.generalTextView2.setText(R.string.taxi_transfer_athens);
                    viewHolder.generalTextView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                            phoneIntent.setData(Uri.parse("tel: +30 698 400 0898"));
                            fragmentg.startActivity(phoneIntent);
                        }
                    });

                    viewHolder.generalTextView3.setText(R.string.CitySightSeeing_athens);
                    viewHolder.generalTextView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri linkUri = Uri.parse("https://www.citysightseeing.gr/");
                            Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);
                            fragmentg.startActivity(linkIntent);
                        }
                    });

                    viewHolder.generalTextView4.setText(R.string.public_bus_service);
                    viewHolder.generalTextView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri linkUri = Uri.parse("http://www.oasa.gr/?lang=en");
                            Intent linkIntent = new Intent(Intent.ACTION_VIEW, linkUri);
                            fragmentg.startActivity(linkIntent);
                        }
                    });
                    break;
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

        if (tag.equals("fragmentG")) {
            viewHolder.mapImageView.setVisibility(View.GONE);
        }

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

        if (tag.equals("fragmentG")) {
            viewHolder.phoneImageView.setVisibility(View.GONE);
        }

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
                photoIntent.setClass(v.getContext(), GalleryActivity.class);
                photoIntent.putExtra("galleryString", places.get(viewHolder.getAdapterPosition()).getGalleryTag());
                fragments.startActivity(photoIntent);
            }
        });

        viewHolder.galleryImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_white);
                        break;
                    case MotionEvent.ACTION_UP:
                        viewHolder.galleryImageView.setBackgroundResource(R.drawable.ic_photo_library_black);
                        break;
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

                switch (tag) {
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
        ImageView placeImageView, mapImageView, phoneImageView, galleryImageView, linkImageView;
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
            galleryImageView = itemView.findViewById(R.id.gallery_image_view);
            linkImageView = itemView.findViewById(R.id.link_image_view);
            hiddenLayout = itemView.findViewById(R.id.hidden_layout);
        }
    }
}
