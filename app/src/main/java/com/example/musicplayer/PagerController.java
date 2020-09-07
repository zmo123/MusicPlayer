package com.example.musicplayer;



import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerController extends FragmentStatePagerAdapter {
    int tabCounts;

    public PagerController(@NonNull FragmentManager fm, int tabCounts) {
        super(fm, tabCounts);
        this.tabCounts = tabCounts;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            Log.i("info", "the page num is " + String.valueOf(i));
            return new currentmusic();
        } else if (i == 1) {
            Log.i("info", "the page num is " + String.valueOf(i));
            return new chart();
        } else {
            Log.i("info", "getItem: null is returned");
            return null;
        }
    }



//    @Override
//    public int getItemPosition(Object object) {
//        // this method will be called for every fragment in the ViewPager
//        if (object instanceof currentmusic || object instanceof chart) {
//            Log.i("info", "getItemPosition: object is either currentMusic or chart");
//            return POSITION_UNCHANGED; // don't force a reload
//        } else {
//            Log.i("info", "getItemPosition: a different object is called! prob musicPlayer");
//            // POSITION_NONE means something like: this fragment is no longer valid
//            // triggering the ViewPager to re-build the instance of this fragment.
//            return POSITION_NONE;
//        }
//    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
