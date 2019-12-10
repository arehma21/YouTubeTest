package com.example.youtubetest;

import android.content.Intent;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private Button button;
    //private Button buttonFrench;
    Button skip;
    Button back;
    private YouTubePlayerView videoplayer;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private YouTubePlayer youtubeplayerInstance;
    private int index = 0;
    private int score = 100;
    private ArrayList<String> answers = new ArrayList<String>();
    private String[] ansArr = new String[5];
    boolean youtubeplayerInitialized = false;
    EditText answerCountry;
    TextView pointTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeAnswers();
        setContentView(R.layout.activity_main);
        answerCountry = findViewById(R.id.countryInput);
        pointTotal = findViewById(R.id.pointTotal);
        //Spinner options = (Spinner) findViewById(R.id.options);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries,
        //        android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //options.setAdapter(adapter);
        //options.setOnItemClickListener(this);
        videoplayer = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        skip = (Button) findViewById(R.id.skipButton);
        back = (Button) findViewById(R.id.backButton);
        //initializeAnswers();

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean b) {
                //youtubeplayer.loadVideo("lS7StcykQF4");
                youtubeplayerInstance = youtubeplayer;
                youtubeplayerInitialized = true;
                youtubeplayer.loadPlaylist("PLneMAXahek_U9RQqSd4-ldMQ6rIT5c58_");

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
                if (youtubeplayerInitialized) {
                    //index++;
                    youtubeplayerInstance.next();
                }
                index++;
                youtubeplayerInstance.next();
                //openFrench();



            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (youtubeplayerInitialized) {
                    //index--;
                    youtubeplayerInstance.previous();
                }
                index--;



            }
        });
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = answerCountry.getText().toString();
                if (answer.equals(answers.get(index))) {
                    score += 50;
                } else {
                    score = score - 5;
                }
                pointTotal.setText(Integer.toString(score));
            }
        });
    }
    public void openFrench() {
        Intent intent = new Intent(MainActivity.this, NextSongFrench.class);
        startActivity(intent);
    }
    public void initializeAnswers() {
        answers.add("France");
        answers.add("Nigeria");
        answers.add("Germany");
        answers.add("Japan");
        answers.add("Turkey");
        answers.add("United Kingdom");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
