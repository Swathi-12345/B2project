package com.example.b2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    /**
     * Sets team name static fields in DataHelper along with maxOvers. ALso handles default values.
     *
     * @param view clicked button
     */
    public void setTeamNames(View view) {
        String teamAName = ((EditText) findViewById(R.id.editText_teamA)).getText().toString();
        String teamBName = ((EditText) findViewById(R.id.editText_teamB)).getText().toString();
        EditText oversEditText = findViewById(R.id.editText_maxOvers);
        int numOfOvers;
        EditText wicketsEditText = findViewById(R.id.editText_maxNumOfWickets);
        int numOfWickets;

        // Set default values
        if (teamAName.isEmpty()) {
            teamAName =getString(R.string.team_a_name);
        }
        if (teamAName.isEmpty()) {
            teamAName =getString(R.string.team_b_name);
        }



        if (oversEditText.getText().toString().isEmpty()) {
            numOfOvers = 20;
        } else {
            numOfOvers = Integer.parseInt(oversEditText.getText().toString());
        }

        if (wicketsEditText.getText().toString().isEmpty()) {
            numOfWickets = 10;

        } else {
            numOfWickets = Integer.parseInt(wicketsEditText.getText().toString());
        }

        // Set static names
        DataHelper.teamAName = teamAName;
        DataHelper.teamBName = teamBName;
        DataHelper.maxNumOfOvers = numOfOvers;
        DataHelper.MAX_WICKETS = numOfWickets;


        // Move to Who Will Bat First chooser
        Intent intent = new Intent(this, WhoBatFirst.class);
        startActivity(intent);
    }
}