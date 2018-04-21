package com.example.jmcghee.workoutroutineplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.ExercisesAdapter;
import com.example.jmcghee.workoutroutineplanner.workout_items.Exercise;

import java.util.List;

public class ExercisesActivity extends AppCompatActivity {

    List<Exercise> exercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra(getString(R.string.exercises_extra))) {
            // Get the workoutSections of the workout that was clicked in the previous activity
            exercises = (List<Exercise>) intentThatStartedThisActivity.getSerializableExtra(getString(R.string.exercises_extra));

            // Initialize the recycler view
            RecyclerView exercisesRecyclerView = findViewById(R.id.rv_exercises);

            // Create a layout manager for the recycler view
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            // Set the layout manager to the recycler view
            exercisesRecyclerView.setLayoutManager(layoutManager);

            // Set fixed sized to true to improve performance
            exercisesRecyclerView.setHasFixedSize(true);

            // Create a new adapter with the sample workouts loaded in
            ExercisesAdapter exercisesAdapter = new ExercisesAdapter(exercises);

            // Attach the adapter to the recycler view
            exercisesRecyclerView.setAdapter(exercisesAdapter);
        }
    }


}
