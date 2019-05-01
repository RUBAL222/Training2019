package com.example.rubal;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener {

    TextView songname;
    Button Playmusic;
    Button StopMusic;
    MediaPlayer mediaPlayer;
    String songToPlay;
    String path;
    String url="https://firebasestorage.googleapis.com/v0/b/nimble-perigee-501.appspot.com/o/Jugni.mp3?alt=media&token=6d08bf51-a745-45c3-a2dc-9f43bec344d7";


    void initViews()
    {

        path= Environment.getExternalStorageDirectory().getPath()+"/"+songToPlay;
        songname=findViewById(R.id.textViewsongname);
        Playmusic=findViewById(R.id.buttonplaymusic);
        StopMusic=findViewById(R.id.buttonstopmusic);

        Playmusic.setOnClickListener(this);
        StopMusic.setOnClickListener(this);

        songname.setText(songToPlay);

        mediaPlayer = new MediaPlayer();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initViews();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonplaymusic)
        {
            try {
                mediaPlayer.setDataSource(this, Uri.parse(url));
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            mediaPlayer.stop();
            mediaPlayer.release();
            finish();

        }

        }
        }

