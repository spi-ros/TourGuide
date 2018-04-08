package com.example.android.tourguide;

import java.util.List;

public class Person {

    private String mName;

    private String mAge;

    private int mPhotoId;

    public Person (String name, String age, int photoId) {
        mName = name;
        mAge = age;
        mPhotoId = photoId;
    }

    public String getName() {
        return mName;
    }

    public String getAge() {
        return mAge;
    }

    public int getPhotoId() {
        return mPhotoId;
    }
}

