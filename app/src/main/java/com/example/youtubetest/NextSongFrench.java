package com.example.youtubetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class NextSongFrench extends YouTubeBaseActivity {
    private Button buttonFrench;
    Button skipFrench;
    private YouTubePlayerView videoplayer;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_song_french);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoplayer = (YouTubePlayerView) findViewById(R.id.videoPlayerFrench);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean b) {
                youtubeplayer.loadVideo("JXtujxT9rzA");

            }
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        //buttonFrench = findViewById(R.id.playVideoFrench);
        buttonFrench.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                videoplayer.initialize("AIzaSyDBlmru2C6N5GGEwxmTXy9eAZfaSX3WVSE", onInitializedListener);

            }

        });
        skipFrench = findViewById(R.id.skipButtonFrench);
        skipFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
