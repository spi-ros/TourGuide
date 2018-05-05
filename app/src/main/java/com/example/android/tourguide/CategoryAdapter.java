package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    Context  context;

    public CategoryAdapter(FragmentManager fragmentManager, Context mContext) {
        super(fragmentManager);
        context = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SitesFragment();
            case 1:
                return new FoodFragment();
            case 2:
                return new HotelsFragment();
            default:
                return new GeneralInfoFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.sites);
            case 1:
                return context.getString(R.string.food);
            case 2:
                return context.getString(R.string.hotels);
            case 3:
                return context.getString(R.string.general_info);
        }
        return null;
    }
}
