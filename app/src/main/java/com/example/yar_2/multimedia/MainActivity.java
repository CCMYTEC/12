package com.example.yar_2.multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(android.R.id.list);
        String[] opciones = {
                "Audio",
                "Video MediaPlayer",
                "Video VideoView",
                "Camara"
        };

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opciones));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent llamar = new Intent(MainActivity.this,AudioActivity.class);
                        startActivity(llamar);
                        break;
                    case 1:
                        Intent llamar2 = new Intent(MainActivity.this,MediaPlayerActivity.class);
                        startActivity(llamar2);
                        break;
                    case 2:
                        Intent llamar3 = new Intent(MainActivity.this,VideoViewActivity.class);
                        startActivity(llamar3);
                        break;
                    case 3:
                        Intent llamar4 = new Intent(MainActivity.this,CamaraActivity.class);
                        startActivity(llamar4);
                        break;
                }
            }
        });
    }
}
