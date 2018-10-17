package com.example.yar_2.multimedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        Uri myUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);

        try{
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
        }catch (IllegalArgumentException e1){
            e1.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SecurityException e2){
            e2.printStackTrace();
        }


        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.SurfaceView);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setKeepScreenOn(true);

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(surfaceHolder);

                try{
                    mediaPlayer.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
}
