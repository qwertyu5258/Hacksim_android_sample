package com.example.openingtest.Main_Fragment1_info;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.example.openingtest.Opening.OpeningActivity;
import com.example.openingtest.R;

/**
 * Created by qwert on 2018-02-16.
 */

public class Fragment1 {

    String tag = "Tag";
    Button button1;
    View rootview;

    public Fragment1() {
    }

    public Fragment1(final View rootview1, final FragmentActivity fragmentActivity) {

        rootview = rootview1;
        button1 = rootview.findViewById(R.id.button1);

        button1.setText("1111111111111");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(rootview1.getContext(), OpeningActivity.class);
                rootview.getContext().startActivity(intent1);

            }
        });

    }
}

