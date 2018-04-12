package com.example.android.tourguide;

public class Place {

    private String mTitle;

    private String mInformation;

    private int mPhoto;

    public Place(String title, String information, int photo) {
        mTitle = title;
        mInformation = information;
        mPhoto = photo;
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
}

