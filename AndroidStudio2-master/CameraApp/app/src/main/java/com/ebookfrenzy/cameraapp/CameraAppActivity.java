package com.ebookfrenzy.cameraapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class CameraAppActivity extends AppCompatActivity {

    private static final int VIDEO_CAPTURE = 101;
    private Uri fileUri;

    public void startRecording(View view)
    {
        File mediaFile = new
                File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myvideo.mp4");

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        fileUri = Uri.fromFile(mediaFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, VIDEO_CAPTURE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_app);

        Button recordButton =
                (Button) findViewById(R.id.recordButton);

        if (!hasCamera())
            recordButton.setEnabled(false);
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Video has been saved to:\n" +
                        fileUri, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Failed to record video.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean hasCamera() {
        return (getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY));
    }
}
