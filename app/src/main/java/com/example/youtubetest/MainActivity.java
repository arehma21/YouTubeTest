package com.example.youtubetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {
    private Button button;
    private Button buttonFrench;
    Button skip;
    private YouTubePlayerView videoplayer;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    //private YouTubePlayer youtubeplayerInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoplayer = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        skip = (Button) findViewById(R.id.skipButton);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean b) {
                youtubeplayer.loadVideo("lS7StcykQF4");
                //youtubeplayerInstance = youtubeplayer;
                //youtubeplayer.loadPlaylist("PLneMAXahek_U9RQqSd4-ldMQ6rIT5c58_");

            }
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        button = findViewById(R.id.playVideo);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                videoplayer.initialize("AIzaSyDBlmru2C6N5GGEwxmTXy9eAZfaSX3WVSE", onInitializedListener);

            }

        });



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //youtubeplayerInstance.next();
                //openFrench();



            }
        });

    }
    public void openFrench() {
        Intent intent = new Intent(MainActivity.this, NextSongFrench.class);
        startActivity(intent);
    }

}
