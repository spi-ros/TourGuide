package com.example.android.tourguide;

import android.content.Intent;

public class Place {

    private String mTitle;

    private String mInformation;

    private int mPhoto;

    private Intent mIntent;

    private String mLocation;

    public Place(String title, String information, int photo, String location) {
        mTitle = title;
        mInformation = information;
        mPhoto = photo;
        mLocation = location;
//        mIntent = intent;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getInformation() {
        return mInformation;
    }

    public int getPhoto() {
        return mPhoto;
    }

    public String getLocation() {
        return mLocation;
    }

//    public Intent getIntent() {
//        return mIntent;
//    }
}

