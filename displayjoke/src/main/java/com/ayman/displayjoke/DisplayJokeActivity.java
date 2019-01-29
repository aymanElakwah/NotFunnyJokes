package com.ayman.displayjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra(JOKE_KEY);
        TextView jokeView = findViewById(R.id.jokeTextView);
        jokeView.setText(joke);
    }
}
