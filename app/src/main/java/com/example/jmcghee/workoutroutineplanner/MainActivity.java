package com.example.jmcghee.workoutroutineplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jmcghee.workoutroutineplanner.data.DataUtils;
import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.WorkoutAdapter;
import com.example.jmcghee.workoutroutineplanner.workout_items.Workout;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WorkoutAdapter.WorkoutClickListener {

    List<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the recycler view
        RecyclerView workoutRecyclerView = findViewById(R.id.rv_workouts);

        // Create a layout manager for the recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Set the layout manager to the recycler view
        workoutRecyclerView.setLayoutManager(layoutManager);

        // Set fixed sized to true to improve performance
        workoutRecyclerView.setHasFixedSize(true);

        // Load the sample workouts
        workouts = DataUtils.createDummyData();

        // Create a new adapter with the sample workouts loaded in
        WorkoutAdapter workoutAdapter = new WorkoutAdapter(workouts, this);

        // Attach the adapter to the recycler view
        workoutRecyclerView.setAdapter(workoutAdapter);
    }

    /**
     * Starts a WorkoutSectionsActivity for a given workout
     *
     * @param index The index of the workout that was clicked
     */
    @Override
    public void onWorkoutClicked(int index) {
        Intent intent = new Intent(MainActivity.this, WorkoutSectionsActivity.class);
        // Pass the data to the next activity
        // In this case the data is the list of workoutSections in the specific Workout that was clicked
        intent.putExtra(getString(R.string.workout_sections_extra), (Serializable) workouts.get(index).getWorkoutSections());
        startActivity(intent);
    }

}
