package com.example.orbital_layoutfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TrackPage extends AppCompatActivity {

    String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_page);

        final int[] yourScore = {0};
        final int[] opponentScore = {0};

        Button endButton = findViewById(R.id.end_button);
        Button catchButton = findViewById(R.id.catch_button);
        Button passButton = findViewById(R.id.pass_button);
        Button cutButton = findViewById(R.id.cut_button);
        Button stallButton = findViewById(R.id.pass_button2);
        Button foulButton = findViewById(R.id.foul_button);
        Button turnoverButton = findViewById(R.id.turnover_button);
        Button pointScoredButton = findViewById(R.id.scored_button);

        TextView possessionText = findViewById(R.id.posession_text);
        TextView catchText = findViewById(R.id.catches_text);
        TextView passText = findViewById(R.id.passes_text);
        TextView cutText = findViewById(R.id.cuts_text);
        TextView scoreText = findViewById(R.id.score_text);

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent().getSerializableExtra("player").addGame(
                        //TODO: MAKE THIS SMART INSTEAD OF JUST TAKING IN EVERYTHING AS SUCCESSFUL
                        new Game(Integer.parseInt(catchText.getText().toString()),
                        0, Integer.parseInt(passText.getText().toString()),
                        Integer.parseInt(passText.getText().toString()),
                        Integer.parseInt(cutText.getText().toString()),
                        Integer.parseInt(cutText.getText().toString()),
                        String.format("%d : %d", yourScore[0], opponentScore[0])));
                startActivity(new Intent(TrackPage.this, PlayerPage.class));
            }
        });

        catchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int catches = Integer.parseInt(catchText.getText().toString());
                catchText.setText(catches + 1);
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int passes = Integer.parseInt(passText.getText().toString());
                passText.setText(passes + 1);
            }
        });

        cutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cuts = Integer.parseInt(cutText.getText().toString());
                cutText.setText(cuts + 1);
            }
        });

        turnoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String possession = possessionText.getText().toString();
                cutText.setText(possession.equals("Offence") ? "Defence" : "Offence");
            }
        });

        pointScoredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (possessionText.getText().toString().equals("Offence")) {
                    yourScore[0]++;
                } else {
                    opponentScore[0]++;
                }
                scoreText.setText(String.format("%d : %d", yourScore[0], opponentScore[0]));
            }
        });
    }
}