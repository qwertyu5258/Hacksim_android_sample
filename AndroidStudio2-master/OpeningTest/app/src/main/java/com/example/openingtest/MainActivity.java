package com.example.openingtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.openingtest.Main_Fragment1_info.Fragment1;
import com.example.openingtest.Main_Fragment3_GoogleMap.GoogleMap2;
import com.example.openingtest.Main_Fragment3_GoogleMap.GoogleMap3;
import com.example.openingtest.Opening.OpeningActivity;
import com.example.openingtest.Setting.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    public static String Tag = "Tag";
    public static View rootview;
    public static ViewGroup Container1;
    public static boolean firstintro = true;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);

        /**
         *   Intro
         */
        if (firstintro == true) {
            Intent intent = new Intent(MainActivity.this, OpeningActivity.class);
            startActivity(intent);
            finish();
        }


        /*****
         *     Main
         ****/

        //툴바
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //탭레이아웃
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_info_outline_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_format_align_left_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_format_list_bulleted_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_format_list_bulleted_black_24dp));


        mViewPager = (ViewPager) findViewById(R.id.container);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);


        //클릭리스너
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case(R.id.action_settings):
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
            break;

            case(R.id.setting2):
                Intent intent1 = new Intent(this, OpeningActivity.class);
                startActivity(intent1);
                break;

            case(R.id.setting3):

                break;

        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Log.d(Tag, String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)));
            Container1 = container;

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {

                View rootView = inflater.inflate(R.layout.activity_maps, container, false);

                rootView.findViewById(R.id.map).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.d(Tag, "클릭됨:::::");
                                    startActivity(new Intent(view.getContext(), GoogleMap2.class));
                                }
                            });

              return rootView;


            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {

                rootview = inflater.inflate(R.layout.fragment1, container, false);

                Fragment1 fragment1 = new Fragment1(rootview, getActivity());

                return rootview;
            } else {


                FragmentManager fragmentManager = getFragmentManager();

                GoogleMap3 mapsActivity = new GoogleMap3();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, mapsActivity);
                fragmentTransaction.commit();



                Log.d(Tag,"들어옴");
                View rootView = inflater.inflate(R.layout.opening, container, false);

                return rootView;

            }
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            Log.d(Tag, "FragmentgetItem");

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
