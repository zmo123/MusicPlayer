package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    Toolbar mToolBar;
    TabLayout mTabLayout;
    TabItem currentMusic;
    TabItem chart;
    ViewPager mPager;
    PagerController mPagerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Stress Management Device");

        mTabLayout = findViewById(R.id.tabLayout);
        currentMusic = findViewById(R.id.currentMusic);
        chart = findViewById(R.id.chart);
        mPager = findViewById(R.id.viewpager);

        mPagerController = new PagerController(getSupportFragmentManager(), mTabLayout.getTabCount());
        mPager.setAdapter(mPagerController);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mToolBar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    Log.i("info", "the currentMusic tab has been selected!");
                    //mPagerController.notifyDataSetChanged();
                    mToolBar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));

                } else if (tab.getPosition() == 1) {
                    Log.i("info", "the chart tab has been selected!");
                    //mPagerController.notifyDataSetChanged();
                    mToolBar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.darker_gray));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.darker_gray));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        View aroot = mTabLayout.getChildAt(0);
        if (aroot instanceof LinearLayout) {
            ((LinearLayout) aroot).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorPrimaryDark));
            drawable.setSize(2, 1);
            ((LinearLayout) aroot).setDividerPadding(10);
            ((LinearLayout) aroot).setDividerDrawable(drawable);
        }

    }

//    public void onBackPressed(){
//        if(getFragmentManager().getBackStackEntryCount() <= 1){
//            super.onBackPressed();
//        } else {
//            getFragmentManager().popBackStack();
//        }
//    }

}


//    @Override
//    public void musicSelected() {
//        Log.i("info", "musicSelected: function is called");
//        musicplayer fragment = new musicplayer();
////        Bundle args = new Bundle();
////        args.putSerializable("songs", mySongs);
////        args.putString("songname", songName);
////        args.putInt("pos", i);
////        fragment.setArguments(args);
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_child_fragment, fragment);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//        Log.i("info",getSupportFragmentManager().getFragments().toString());
//        //mPagerController.notifyDataSetChanged();
//
//    }
//}
