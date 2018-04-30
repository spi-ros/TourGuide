package com.example.android.tourguide;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    String intentString;
    GridView gridview;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new GalleryAdapter(this));

        Intent photoIntent = this.getIntent();

        if (photoIntent != null) {
            intentString = Objects.requireNonNull(photoIntent.getExtras()).getString("testString");
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public class GalleryAdapter extends BaseAdapter {

        Display display = ((WindowManager) Objects.requireNonNull(getSystemService(WINDOW_SERVICE)))
                .getDefaultDisplay();
        int orientation = display.getOrientation();
        private Context mContext;
        private Integer[] acropolisGallery = {
                R.drawable.acropolis_gallery_photo0, R.drawable.acropolis_gallery_photo1
        };
        private Integer[] agoraGallery = {
                R.drawable.agora_gallery_photo0, R.drawable.agora_gallery_photo1
        };
        private Integer[] monastirakiGallery = {
                R.drawable.monastiraki_gallery_photo0, R.drawable.monastiraki_gallery_photo1
        };
        private Integer[] odeonGallery = {
                R.drawable.odeon_gallery_photo0, R.drawable.odeon_gallery_photo1
        };
        private Integer[] olympianZeusGallery = {
                R.drawable.olympian_zeus_gallery_photo0, R.drawable.olympian_zeus_gallery_photo1
        };
        private Integer[] poseidonGallery = {
                R.drawable.temple_of_poseidon_gallery_0, R.drawable.temple_of_poseidon_gallery_1
        };

        GalleryAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return 2;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ImageView fullScreenImage = findViewById(R.id.fullScreen_image_view);
            final ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(700, 700));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(8, 8, 8, 8);

                switch (orientation) {
                    case Configuration.ORIENTATION_PORTRAIT:
                        gridview.setNumColumns(3);
//                        imageView.setLayoutParams(new ViewGroup.LayoutParams(1200, 1200));
//                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                }
            } else {
                imageView = (ImageView) convertView;
            }

            switch (intentString) {
                case "sites_tag_1":
                    imageView.setImageResource(poseidonGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(poseidonGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
                case "sites_tag_2":
                    imageView.setImageResource(acropolisGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(acropolisGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
                case "sites_tag_3":
                    imageView.setImageResource(odeonGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(odeonGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
                case "sites_tag_4":
                    imageView.setImageResource(agoraGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(agoraGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
                case "sites_tag_5":
                    imageView.setImageResource(monastirakiGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(monastirakiGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
                case "sites_tag_6":
                    imageView.setImageResource(olympianZeusGallery[position]);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridview.setVisibility(View.GONE);

                            fullScreenImage.setImageResource(olympianZeusGallery[position]);
                            fullScreenImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

                            switch (orientation) {
                                case Configuration.ORIENTATION_PORTRAIT:
                                    fullScreenImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                    break;
                            }
                        }
                    });
                    break;
            }

            fullScreenImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(getIntent());
                }
            });
            return imageView;
        }
    }
}