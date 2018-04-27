package com.example.android.tourguide;

public class Place {

    private String mTitle;

    private String mInformation;

    private int mPhoto;

    private String mLocation;

    private String mPhoneNumber;

    private String mTag;

    private String mLink;

    private String mGalleryTag;

    public Place(String title, String information, int photo, String location,
                 String phoneNumber, String tag, String link, String galleryTag) {
        mTitle = title;
        mInformation = information;
        mPhoto = photo;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mTag = tag;
        mLink = link;
        mGalleryTag = galleryTag;
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

    public String getTag() {
        return mTag;
    }

    public String getLink() {
        return mLink;
    }

    public String getGalleryTag() {
        return mGalleryTag;
    }
}

