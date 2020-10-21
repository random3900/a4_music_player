package com.example.a4_musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class PlayMusic extends AppCompatActivity implements View.OnClickListener {

    ImageView play_pause,prev,next,pic;
    boolean playOrPause;
    int pos;

    static int[] pictures = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Bundle b = getIntent().getExtras();
        pos = Integer.parseInt(b.getString("Pos"));
        Log.d("PlayMusic", Integer.toString(pos));
//        pos = 0;
        play_pause = findViewById(R.id.playIV);
        prev = findViewById(R.id.prevIV);
        next = findViewById(R.id.nextIV);
        pic = findViewById(R.id.pictureIV);
        pic.setImageResource(pictures[pos]);

        play_pause.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);

        playOrPause = false;

        Intent startIntent = new Intent(this,MusicService.class);
        startIntent.putExtra("Pos", Integer.toString(pos));
        startIntent.setAction("com.example.foregroundservice.action.startforeground");
        startService(startIntent);

    }

    @Override
    public void onClick(View view) {
        if(view == play_pause){
            Intent startIntent = new Intent(this,MusicService.class);
            startIntent.setAction(Constants.ACTION.PLAY_ACTION);
            startService(startIntent);
            if(playOrPause==false){
                play_pause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
            }
            else{
                play_pause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
            }
            playOrPause = !playOrPause;
        }
        else {
            if (view == prev) {
                Intent startIntent = new Intent(this,MusicService.class);
                startIntent.setAction(Constants.ACTION.PREV_ACTION);
                startService(startIntent);
                pos = pos>0? pos-1:2;
                pic.setImageResource(pictures[pos]);
                play_pause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);

            }
            else if (view == next) {
                Intent startIntent = new Intent(this,MusicService.class);
                startIntent.setAction(Constants.ACTION.NEXT_ACTION);
                startService(startIntent);
               pos = (pos+1)%3;
                pic.setImageResource(pictures[pos]);
                play_pause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
            }



        }
    }

}