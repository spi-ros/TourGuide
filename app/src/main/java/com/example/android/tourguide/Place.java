package com.example.android.tourguide;

public class Place {

    private String mTitle;

    private String mInformation;

    private int mPhoto;

    private String mLocation;

    private String mPhoneNumber;

    private String mFragmentTag;

    private String mLink;

    private String mAssistTag;

    public Place(String title, String information, int photo, String location,
                 String phoneNumber, String fragmentTag, String link, String assistTag) {
        mTitle = title;
        mInformation = information;
        mPhoto = photo;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mFragmentTag = fragmentTag;
        mLink = link;
        mAssistTag = assistTag;
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

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getFragmentTag() {
        return mFragmentTag;
    }

    public String getLink() {
        return mLink;
    }

    public String getAssistTag() {
        return mAssistTag;
    }
}

