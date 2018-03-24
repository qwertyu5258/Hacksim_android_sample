package com.example.openingtest.Main_Fragment2_GoogleMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.openingtest.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private FragmentActivity myContext;
    private GoogleMap mMap;
    String tag = "MapActivity";

    public MapsActivity() {

    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;

        super.onAttach(activity);
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myContext.setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) myContext.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.d(tag,"container::"+ String.valueOf(container));
        return inflater.inflate(R.layout.activity_maps, container, false);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        LatLng Seoul = new LatLng(37.566535, 126.977969);
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.566535, 126.977969))
                .title("Marker in seoul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Seoul));
    }
}
