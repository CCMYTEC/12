package com.example.yar_2.multimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);


        Uri uriVideo = Uri.parse("android:resource://"+getPackageName()+"/"+R.raw.video);

        VideoView videoView = (VideoView)findViewById(R.id.videoviu);

        videoView.setVideoURI(uriVideo);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();

    }
}
