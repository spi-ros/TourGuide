package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

// CategoryAdapter is a FragmentPagerAdapter that can provide the layout for
// each list item based on a data source which is a list of Tunes objects.
public class CategoryAdapter extends FragmentPagerAdapter {

    // Titles of the Tabs.
    private String tabTitles[] = new String[]{"Sites", "Food"};

    // Create a new CategoryAdapter object
    public CategoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Return the Fragment that should be displayed for the given page number.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SitesFragment();
        } else {
            return new FoodFragment();
        }
    }

    // Return the total number of pages.
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
