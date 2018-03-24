package com.example.aninterface;

import android.app.ActionBar;
import android.app.ActivityGroup;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;

public class MainActivity extends ActivityGroup {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ActionBar actionBar = getActionBar();
        actionBar.setTitle("1111");
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar_actions,menu);

        return true;
    }


}
