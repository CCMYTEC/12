package com.example.yar_2.multimedia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {

    private ImageButton buttonPlay, buttonPause, buttonStop;
    private TextView textEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        buttonPlay = (ImageButton)findViewById(R.id.button_play);
        buttonPause = (ImageButton)findViewById(R.id.button_pause);
        buttonStop = (ImageButton)findViewById(R.id.button_stop);
        textEstado = (TextView)findViewById(R.id.text_estado);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cancion);
        mediaPlayer.start();
        textEstado.setText("Reproduciendo");

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    textEstado.setText("Pausado");
                }
                else{
                    mediaPlayer.start();
                    textEstado.setText("Reproduciendo");
                }

            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    textEstado.setText("Pausado");
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    textEstado.setText("Detenido");
                    try{
                        mediaPlayer.prepare();
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
